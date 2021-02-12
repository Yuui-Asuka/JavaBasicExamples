package cocurrent.java.threadCreate;

import cocurrent.java.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public static void threadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Create2());
        executorService.execute(new Create3());
    }
}
