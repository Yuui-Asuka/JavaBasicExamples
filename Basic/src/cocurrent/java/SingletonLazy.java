package cocurrent.java;

public class Singleton2 {

    /**
     * 懒汉模式单例
     */
    private static Singleton2 singleton2 = null;

    /**
     * 构造函数私有
     */
    private Singleton2(){}


    public static Singleton2 singleton2() {
        if (null == singleton2){
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
            singleton2 = new Singleton2();
        }
        return singleton2;
    }


}
