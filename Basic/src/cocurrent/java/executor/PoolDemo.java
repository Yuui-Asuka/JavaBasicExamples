package cocurrent.java.executor;

import cocurrent.java.communication.threadlocal.ThreadLocalDemo;

import java.util.concurrent.*;

/**
 * 执行完成之后有相应的返回值时使用callable
 */
public class PoolDemo {
    public static void test() throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        //五个参数分别为: 核心线程池大小 线程池最大容量 当线程数量大于核心时，多余空闲线程在终止之前等待新任务的最大时间
        //               时间单位  工作队列
        //当任务数量 < 核心线程池大小时，启动任务数量个线程
        //当任务数量 >= 核心线程池大小但 < 工作队列+核心数量时，启动 <= 核心数量个线程，其他任务放入工作队列
        //当任务数量 > 核心线程池大小+工作队列时，
        //如果(x - nworks < mSize) 会启动x-nworks个线程
        //如果(x - nworks >= mSize) 会启动mSize个线程 其余的执行相应的拒绝策略

        //线程池的四种拒绝策略分别为：
        //AbortPolicy: 该策略直接抛出异常，阻止系统正常工作。
        //CallerRunPolicy: 只要线程池没有关闭，该策略直接在调用者线程中，执行当前被丢弃的任务
        //DiscardPolicy: 直接把任务丢弃
        //DiscardOldestPolicy:丢弃最老的一个请求(任务队列里面的第一个)，再尝试提交任务
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                20, 3L,
                TimeUnit.SECONDS, linkedBlockingQueue, new CustomPolicy());
        threadPoolExecutor.prestartAllCoreThreads();
        Future<String> submit = null;
        for (int i = 0; i < 50; i++){
            threadPoolExecutor.submit(()->{
                try {
                    System.out.println(threadPoolExecutor.getActiveCount());
                    Thread.sleep(20L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

//        for (int i = 0; i < 100; i++){
//           submit = threadPoolExecutor.submit(new CallDemo());
//                System.out.println(Thread.currentThread().getName());
//            };
//        for (int i = 0; i < 100; i++){
//            System.out.println(submit.get());
//        }
        }
    }
