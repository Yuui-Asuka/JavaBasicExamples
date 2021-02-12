package cocurrent.java;

public class Syn {

    private final Object lock = new Object();

    /**
     * 修饰普通方法，锁住对象的实例
     * @throws InterruptedException
     */
    public synchronized void out() throws InterruptedException{
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100L);
    }

    /**
     * 当修饰静态方法的时候，锁住的是整个类
     */
    public synchronized static void staticOut(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test(){
        Syn syn1 = new Syn();
        Syn syn2 = new Syn();
        new Thread(()->{
            try {
                syn1.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                syn2.out();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 当修饰一个代码块的时候，锁住的是括号里的对象
     */
    public void test2(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void test3(){
        /**
         * 启动十个线程 每次都会进入锁
         */
        for (int i = 0; i < 10; i++){
            new Thread(this::test2).start();
        }
    }

}
