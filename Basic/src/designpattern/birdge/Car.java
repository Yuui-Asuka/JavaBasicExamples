package designpattern.birdge;

public abstract class Car {

    /**
     * 汽车的抽象类持有color的对象和configuration对象
     * 通过组合方式桥接其他的行为
     * 在抽象层聚合关联
     */
    protected Color color;

    protected Configuration configuration;

    public Car setColor(Color color) {
        this.color = color;
        return this;
    }

    public Car setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * 汽车的方法
     */
    abstract public void run();
}
