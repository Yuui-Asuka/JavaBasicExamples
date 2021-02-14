package cocurrent.java.containter;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueue {
    public static void test() throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings.add("111");
        strings.add("111");
        strings.add("111");
        System.out.println(strings.remove("111"));
        strings.poll();
        strings.take();
    }
}
