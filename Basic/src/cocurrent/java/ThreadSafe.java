package cocurrent.java;

import java.util.concurrent.CountDownLatch;

public class ThreadSafe {

    /**
     * volatile只保证变量的可见性 不保证原子性
     */
    private static volatile int num = 0;

    private ThreadSafe(){}

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * 使用synchronized关键字保证方法的原子性执行
     * 线程进入同步代码块的时候会自动获得内置锁
     * synchronized不能修饰类，但是可以修饰方法和静态方法
     */
    private static synchronized void iAdd(){
        /**
         * num++不是原子性操作，使得两个线程同时读取了相同的num值
         * 原子性操作：一系列操作要么全部成功，要么全部失败。
         */
        num++;
    }

    /**
     * 线程之间未进行同步操作
     */
    public static void threads(){
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                for (int j = 0; j < 100; j++){
                    iAdd();
                    try {
                        Thread.sleep(1L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        while (true) {
            if (countDownLatch.getCount() == 0) {
                /**
                 * 打印的数字不是1000
                 */
                System.out.println(num);
                break;
            }
        }
    }
}
