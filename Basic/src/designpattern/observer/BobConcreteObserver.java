package designpattern.observer;

public class BobConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Bob接受到消息");
    }
}
