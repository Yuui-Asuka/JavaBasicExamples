package cocurrent.java.communication.provider;

public class Provider implements Runnable{
    /**
     * 不能使用new去构建 否则生产者消费者会产生两个不同实例
     */
    private MediumInterface medium;

    public Provider(MediumInterface medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.put();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
