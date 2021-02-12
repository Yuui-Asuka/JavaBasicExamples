package cocurrent.java;
import java.lang.runtime.*;

public class SingletonLazy {

    /**
     * 懒汉模式单例
     */
    private static SingletonLazy singletonLazy = null;

    /**
     * 构造函数私有
     */
    private SingletonLazy(){}

    /**
     * 多线程下会有线程安全性问题
     * @return singletonLazy
     */
    public static SingletonLazy singletonTest1() {
        if (null == singletonLazy){
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

    /**
     * 对静态方法加锁，可以保证线程安全，但是会降低性能。
     * @return
     */
    public static synchronized SingletonLazy SingletonTest2(){
        if (null == singletonLazy){
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

    /**
     * 使用更细粒度的锁，但是由于所有的线程都已经进入方法并进行等待，因此仍然会创建多个实例。
     * @return
     */
    public static SingletonLazy SingletonTest3(){
        if (null == singletonLazy){
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (Singleton.class) {
                singletonLazy = new SingletonLazy();
            }
        }
        return singletonLazy;
    }

    /**
     * 使用双重检测锁，可以保证线程安全。
     * @return
     */
    public static SingletonLazy SingletonTest4(){
        if (null == singletonLazy){
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (Singleton.class) {
                if(null == singletonLazy){
                singletonLazy = new SingletonLazy();
            }
            }
        }
        Runtime.getRuntime();
        return singletonLazy;
    }



}
