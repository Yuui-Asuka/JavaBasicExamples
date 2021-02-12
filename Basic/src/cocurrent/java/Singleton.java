package cocurrent.java;

public class Singleton {

    /**
     * 饿汉模式的单例。在类加载的时候就会实例化，会造成内存的浪费。
     */
    private static final Singleton singleton = new Singleton();

    private Singleton(){}

    /**
     * 使用饿汉模式启动单例
     * @return
     */
    public static Singleton singleTest1(){
        System.out.println(Thread.currentThread().getName() + " " + singleton);
        return singleton;
    }
}

