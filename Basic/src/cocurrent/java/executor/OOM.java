package cocurrent.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实际使用中尽量不用Executor框架去创建线程池
 * 本例模拟OOM内存不足的异常
 * 在VM options中设置：
 * -Xms100m
 * -Xmx100m
 * 
 */
public class OOM {
    public static void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (true){
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }

}
