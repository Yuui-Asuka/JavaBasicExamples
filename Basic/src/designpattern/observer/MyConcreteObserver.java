package designpattern.observer;

public class MyConcreteObserver implements Observer{

    @Override
    public void update() {
        System.out.println("我收到消息之后进行消费");
    }
}
