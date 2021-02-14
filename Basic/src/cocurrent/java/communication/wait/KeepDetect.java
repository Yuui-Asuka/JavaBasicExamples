package cocurrent.java.communication.wait;

public class KeepDetect {

    private static volatile boolean flag = false;

    /**
     * 模型1：用一个空循环去不断地检测flag的状态
     * 缺点：空循环期间需要一直检测flag的状态，不知道什么时候flag会变成true
     * 空循环会消耗CPU的资源，休眠的时间不可预估
     * @throws InterruptedException
     */
    public static void test() throws InterruptedException {
        new Thread(()->{
            while (!flag){
                try {
                    //sleep的作用是让线程在指定时间内不去抢占cpu资源，但是不会释放锁
                    Thread.sleep(10L);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }
            System.out.println("flag is true");

        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag = true;
        }).start();

    }

}
