package cocurrent.java.tool;
import java.util.concurrent.CountDownLatch;


public class CountDown {
    public static void test(){
    CountDownLatch countDownLatch = new CountDownLatch(8);
    //当8个线程都已经结束之后，再执行该线程
    new Thread(()->{
        try {
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("所有线程都已经结束");
    }).start();
    //模拟8个线程，8个线程以不同的速度结束
    for (int i = 0; i < 8; i++){
        int I = i;
        new Thread(()->{try {
            Thread.sleep(I * 1000L);
            System.out.println(Thread.currentThread().getName() + "到达终点");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }}).start();

    }}
}
