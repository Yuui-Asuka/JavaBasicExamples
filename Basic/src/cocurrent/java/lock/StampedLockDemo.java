package cocurrent.java.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * JDK1.8新增邮戳锁
 * 一般应用都是读多写少，由于读写是互斥操作，因此可能造成写线程饥饿
 * 获取锁的方法会得到一个stamp,如果为0则获取失败，不为0则成功，而释放锁的邮戳需要和获取锁时的邮戳一致
 * 支持降级和升级 不可重入，获取锁的情况下再去获取则会发生死锁。
 * 支持乐观读和悲观读
 * 性能远高于ReentryReadWriteLock
 */
public class StampedLockDemo {
    private double x, y;

    private StampedLock s1 = new StampedLock();

    /**
     * 写操作，将x,y分别写入内存
     * @param X
     * @param Y
     */
    void write(double X, double Y){
        long stamp = s1.writeLock();
        try {
            x += X;
            y += Y;
        } finally {
            s1.unlockWrite(stamp);
        }
    }

    void read(){
        //尝试获取乐观读锁
        long stamp = s1.tryOptimisticRead();
        double currentX = x, currentY = y;
        //检查获取到读锁的stamp之后，锁有没有被其他线程互斥地抢占
        if (!s1.validate(stamp)){
            // 如果被抢占则获取一个悲观读锁
            stamp = s1.readLock();
        }
        try {
            currentX = x;
            currentY = y;
        }finally {
            //释放读锁
            s1.unlockRead(stamp);
        }
    }

    /**
     * 使用悲观锁获取读锁，并尝试转换为写锁
     */
    void convert(double newX, double newY) {
        long stamp = s1.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                //尝试获取读锁并升级为写锁
                long ws = s1.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    //读锁升级失败则释放读锁，显式获取独占写锁，并循环重试
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }
            }
    } finally {
            //释放锁
            s1.unlock(stamp);
        }
    }
}
