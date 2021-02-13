package cocurrent.java.communication.provider;

public class Consumer implements Runnable{

    /**
     * 不能使用new去构建 否则生产者消费者会产生两个不同实例
     */
    private Medium medium;

    public Consumer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }

}
