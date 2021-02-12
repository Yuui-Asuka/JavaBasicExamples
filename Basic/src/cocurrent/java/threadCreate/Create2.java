package cocurrent.java.threadCreate;

/**
 * 一般使用runnable创建线程，因为Java允许单继承但是可以实现多个接口，并且有利于解耦
 * 启动线程的时候要使用start()方法
 */
public class Create2 implements Runnable{

    @Override
    public void run() {
        Thread.currentThread().setName("线程2");
        System.out.println(Thread.currentThread().getName());
    }
}
