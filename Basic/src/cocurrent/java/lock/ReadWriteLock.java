package cocurrent.java.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的基本使用
 * 读读共享，读写互斥，写写互斥
 */

/**
 * ==========================================================
 * 读写锁的基本原理--------AQS如何使用单一int值表示读写两种状态
 * 将32位int拆分成两半无符号的short
 *
 * 高位表示读锁         低位表示写锁
 * 0000000000000000  0000000000000000
 *
 * 两种锁的最大重入次数均为2^16-1 即65535
 *
 * 读锁：
 * 0000000000000000  0000000000000000
 * 当有一个线程进入时，将会加上65536
 * 0000000000000001  0000000000000000
 * 如果要获取读锁的个数，则把该无符号数右移16位,得到：
 * 0000000000000000  0000000000000001
 * 即表示读锁的个数
 *
 * 写锁：
 * 0000000000000000  0000000000000000
 * 每次线程进入，直接加1
 * 0000000000000000  0000000000000001
 * 如果要获取写锁的个数，和65535进行and运算
 *
 * 0000000000000000  1111111111111111 & 0000000000000000  0000000000000001
 * 得到：
 * 0000000000000000  0000000000000001
 *
 */


public class ReadWriteLock {

    private int num = 0;
    private int num1 = 0;

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    // 读锁
    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    // 写锁
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     * 读操作
     */
    public void out(){
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " num的值: " + num + "  num1的值 " + num1);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 写操作
     */
    public void inCreate() {
        try {
            writeLock.lock();
            num++;
            try {
                Thread.sleep(100L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            num1++;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
