package designpattern.proxy;

/**
 * 设计模式的优点：符合开闭原则，具有良好的灵活性和扩展性
 * 缺点: 增加调用链路和系统的复杂性
 */
public class main {
    public static void main(String[] args) {
        /**
         * 真实对象的行为
         */
        Developers realObj = new DevelopersReal();
        realObj.run();

        /**
         * 代理对象的行为
         */
        Developers proxy = new Proxy();
        proxy.run();
    }
}
