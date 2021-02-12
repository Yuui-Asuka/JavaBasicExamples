package cocurrent.java;

import java.util.concurrent.TimeUnit;

/**
 * 线程间的死锁演示
 */
public class DeadLock {
    private static final Object MUTEX_A = new Object();
    private static final Object MUTEX_B = new Object();

    /**
     * 由于线程相互等待而形成死锁
     */
    public static void test(){
        new Thread(()->{
            synchronized (MUTEX_A){
                System.out.println("线程1获得了A资源");
                System.out.println(System.currentTimeMillis());
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MUTEX_B){
                    System.out.println("线程1获得了B资源");
                    System.out.println(System.currentTimeMillis());
                }
            }
        }).start();

        new Thread(()->{
            synchronized (MUTEX_B){
                System.out.println("线程2获得了B资源");
                System.out.println(System.currentTimeMillis());
                synchronized (MUTEX_A){
                    System.out.println("线程2获得了A资源");
                    System.out.println(System.currentTimeMillis());
                }
            }
        }).start();
    }
}
