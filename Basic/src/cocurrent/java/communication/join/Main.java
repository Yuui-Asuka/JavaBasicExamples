package cocurrent.java.communication.join;

/**
 * join的应用场景：当A运行到一半需要某些数据
 */
public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            try {
                Thread.sleep(3000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束运行");
        }, "线程1");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行");
            thread1.start();
            // 使用join方法，线程2会等待线程1运行完成以后才继续运行。join方法内部仍然是使用了wait方法
            try {
                thread1.join();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程2结束运行");
        }, "线程2").start();

    }
}
