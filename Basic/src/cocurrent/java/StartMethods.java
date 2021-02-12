package cocurrent.java;

import cocurrent.java.lock.RLock;
import cocurrent.java.lock.ReentryLockTest;
import cocurrent.java.threadCreate.Create2;
import cocurrent.java.threadCreate.Create3;
import cocurrent.java.threadCreate.Executor;

public class StartMethods {

    /**
     * 死锁
     */
    public static void deadLock(){
        DeadLock.test();
    }

    /**
     * 线程安全
     */
    public static void threadSafe(){
        ThreadSafe.threads();
    }

    /**
     * 新线程
     */
    public static void threadCreate(){
        Thread thread = new Thread(new Create2());
        thread.start();
    }

    /**
     * 线程池
     */
    public static void threadPool(){
        Executor.threadPool();
    }

    /**
     * 线程等待和恢复
     * @throws InterruptedException
     */
    public static void threadWait() throws InterruptedException {
        Create3 create3 = new Create3();
        Thread thread = new Thread(create3);
        thread.start();
        Thread.sleep(1000L);
        synchronized (create3.obj) {
            create3.obj.notify();
        }
    }

    public static void singleton(){
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                Singleton.singleTest1();
            }).start();
        }
    }

    public static void singletonLazy(){
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                //SingletonLazy singletonLazy = SingletonLazy.singletonTest1();
               // SingletonLazy singletonLazy = SingletonLazy.SingletonTest2();
               // SingletonLazy singletonLazy = SingletonLazy.SingletonTest3();
                SingletonLazy singletonLazy = SingletonLazy.SingletonTest4();
                System.out.println(singletonLazy);
            }).start();
        }
    }

    public static void rLock(){
        RLock.threadStart();
    }

    public static void rLockTest(){
        ReentryLockTest.methodA();
    }


}
