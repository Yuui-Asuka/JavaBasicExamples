package cocurrent.java.communication.wait;

public class WaitAndNotify {
    private static volatile boolean flag = false;

    private final Object obj = new Object();
    /**
     * 模型2：使用wait和notify进行状态检测
     * @throws InterruptedException
     */
    public void test() throws InterruptedException {
        new Thread(()->{
            while (!flag){
                //在wait和notify的时候要持有相同的对象锁
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("flag is false");
                }
                System.out.println("flag is true");
            }
        }).start();

        Thread.sleep(1000L);

        /**
         * 如果有两个线程都在wait,那么必须调用notifyAll()。notify只是随机地
         * 唤醒一个在等待的线程
         */
        new Thread(()->{
            while (!flag){
                //在wait和notify的时候要持有相同的对象锁
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("flag is false");
                }
                System.out.println("flag is true");
            }
        }).start();


        new Thread(()->{
            flag = true;
            synchronized (obj){
                obj.notifyAll();
            }
        }).start();
    }
}
