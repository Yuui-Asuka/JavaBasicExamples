package cocurrent.java.lock;

public class ReentryLockTest {

    private static MyLock myLock = new MyLock();

    public static void methodA(){
        myLock.lock();
        new Thread(()->{
            System.out.println("进入线程A");
            methodB();
        }).start();
        myLock.unlock();
    }

    private static void methodB(){
        myLock.lock();
        new Thread(()->{
            System.out.println("进入线程B");
        }).start();
        myLock.unlock();
    }
}
