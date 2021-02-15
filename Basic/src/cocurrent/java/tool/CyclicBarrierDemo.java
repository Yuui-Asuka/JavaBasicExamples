package cocurrent.java.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * 允许一组线程相互等待达到一个公共障碍点，之后继续执行，于countdownLatch相似
 * countdownLatch是某一线程等待一组线程就绪之后继续执行，不可重复使用
 * CyclicBarrier是一系列线程共同等待某一状态，可重复使用
 */
public class CyclicBarrierDemo {
    public static void test(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i < 8; i++) {
            int I = i;
            new Thread(()->{
                try {
                    Thread.sleep(I * 1000L);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("所有线程准备就绪");
            }).start();
        }

    }
}
