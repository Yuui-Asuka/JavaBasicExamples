package cocurrent.java.tool;

import java.util.concurrent.Exchanger;

/**
 * 提供一个同步点，两个线程可以可以在同步点交换数据
 * 如果A线程先执行exchange，它会等待B线程也执行该方法
 * 当两个线程都到达同步点时，可以彼此交换数据
 * 该方法执行的对象是【成对的】线程
 */
public class ExchangeData {

    public static void test(){
        Exchanger<String> stringExchanger = new Exchanger<>();

        String str1 = "Bob";
        String str2 = "Cat";

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "初始值======>" + str1);
            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName() + "交换后的值======>" + exchange);
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "线程1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "初始值======>" + str2);
            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + "交换后的值======>" + exchange);
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "线程2").start();


    }
}
