import cocurrent.java.DeadLock;
import cocurrent.java.StartMethods;
import cocurrent.java.ThreadSafe;
import cocurrent.java.threadCreate.Create;
import cocurrent.java.threadCreate.Create2;
import cocurrent.java.threadCreate.Create3;
import cocurrent.java.threadCreate.Executor;

public class main {
    public static void main(String[] args) throws InterruptedException {
        //DeadLock.test();
    //    ThreadSafe.threads();
//        Thread thread = new Thread(new Create2());
//        thread.start();
//        Executor.threadPool();
//        Create3 create3 = new Create3();
//        Thread thread = new Thread(create3);
//        thread.start();
//        Thread.sleep(1000L);
//        synchronized (create3.obj){
//            create3.obj.notify();
//        }
        /**
         * 一旦调用，线程立刻停止，会引发线程安全性问题。
         */
       // thread.stop();
       // StartMethods.singletonLazy();
        StartMethods.rLock();
       // StartMethods.rLockTest();
    }
}
