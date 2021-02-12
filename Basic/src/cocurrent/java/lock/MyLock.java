package cocurrent.java.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private static boolean isHoldLock = false;

    // 重入次数
    private static int reentryCount = 0;

    private static Thread holdThread = null;


    @Override
    public synchronized void lock() {
        if (isHoldLock && holdThread != Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 将持有锁的线程设为当前线程
        holdThread = Thread.currentThread();

        // 获取锁之后其他线程无法再获取

        isHoldLock = true;
        reentryCount++;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        //判断持有锁的线程是否是当前线程
        if (Thread.currentThread() == holdThread){
            reentryCount--;
            if (reentryCount == 0){
                notify();
                isHoldLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
