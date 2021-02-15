package cocurrent.java.tool;

import java.util.concurrent.Semaphore;

/**
 * 控制线程的并发数量
 * 使用场景：接口限流
 */
public class SemaphoreDemo {
    public static void test(){
        Semaphore semaphore = new Semaphore(8);
        for (int i = 0; i < 15; i++){
            int I = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(I * 1000L);
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
