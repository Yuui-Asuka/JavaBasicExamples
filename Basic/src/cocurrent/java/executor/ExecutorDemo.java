package cocurrent.java.executor;

import cocurrent.java.threadCreate.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorDemo {

    public static void test(){
        //创建一个可以根据需要创建新线程的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //固定大小的线程池，在任何时候最多只有N个线程处理任务
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        //能延迟执行、定时执行任务
        ScheduledExecutorService scheduledExecutorService
                 = Executors.newScheduledThreadPool(2);
        //任务窃取 使用多个队列减少竞争 从JDK1.8开始支持
        ExecutorService executorService2 = Executors.newWorkStealingPool();
        //单一线程的线程池，只会使用唯一的一个线程来执行任务，即使提交再多的任务，
        //也都会放到队列中等待
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 =
                Executors.newSingleThreadScheduledExecutor();
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }


}
