package cocurrent.java.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable方法有返回值，可以返回给客户端，而runnable无返回值，一般情况下
 * callable与futureTask一起使用，或者通过线程池的submit方法返回相应的Future
 */
public class CallDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000L);
        return "ddd";
    }

    public static void test() throws ExecutionException, InterruptedException {
        CallDemo callDemo = new CallDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(callDemo);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
}
