package cocurrent.java.threadCreate;

import com.sun.source.tree.SynchronizedTree;

import java.util.concurrent.SynchronousQueue;

public class Create3 implements Runnable{

    public final Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            System.out.println("线程持有资源");
            /**
            suspend()可能会引起死锁
             */
//            Thread.currentThread().suspend();
//            Thread.currentThread().resume();
            /**
             * 使用wait和notify可以释放锁
             */
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程释放资源");
        Thread.currentThread().setName("线程3");
        System.out.println(Thread.currentThread().getName());
    }
}
