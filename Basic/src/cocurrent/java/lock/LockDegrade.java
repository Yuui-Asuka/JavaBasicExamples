package cocurrent.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
 *
 * 写线程获得写入锁之后可以获取读取锁，然后释放写入锁，就可以降级成读锁
 * 锁降级之后，写锁并不会直接降级成读锁，不会随着读锁的释放而释放，因此需要显式地释放写锁
 * 锁只有降级，没有升级
 * 因为：读锁可以由多个线程持有，写锁只有一个线程持有。
 * 锁降级应用：
 * 用于对数据比较敏感的场景，需要在对数据修改之后，获取修改后的值，并进行接下来的操作
 */
public class LockDegrade {

    private int i = 0;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    /**
     * 如果不加读写锁，那么10个线程将快速地将i自增10次并写入，
     * 之后等待所有线程休眠结束，取回内存中地值时，10个线程都会拿到10，而不是各自加1之后的结果。
     */
    public void test(){
        try {
            i++;
            Thread.sleep(1000L);
        } catch (Exception e){
            e.printStackTrace();
        }

        if (i == 1) {
            System.out.println("i的值是 1");
        } else {
            System.out.println("i的值是 " + i);
        }
    }


    /**
     * 加了读写锁之后会发现，前两个线程可以输出不同的数值，而后面8个线程拿到的值都是10
     * 因为后面的8个线程优先获取了写锁，先进行了写入操作
     */
    public void test2(){
        writeLock.lock();
        try {
            i++;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        try {
            Thread.sleep(10L);
        } catch (Exception e){
            e.printStackTrace();
        }

        readLock.lock();
        try {
            if (i == 1) {
                System.out.println("i的值是 1");
            } else {
                System.out.println("i的值是 " + i);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//        Lock readLock = reentrantReadWriteLock.readLock();
//        Lock writeLock = reentrantReadWriteLock.writeLock();
//
//        readLock.lock();
//        writeLock.lock();
//        writeLock.unlock();
//        readLock.unlock();
    }

    /**
     * 在写锁未释放的时候获取读锁，可以完成锁降级，从而获取正确的数值。
     */
    public void test3() {
        writeLock.lock();
        try {
            i++;
            readLock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        try {
            Thread.sleep(10L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (i == 1) {
                System.out.println("i的值是 1");
            } else {
                System.out.println("i的值是 " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
