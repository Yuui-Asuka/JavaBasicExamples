package designpattern.observer;

/**
 * 定义对象间一对多的依赖关系，使得每当一个对象改变状态，则所有依赖它的对象都会得到通知并自动更新
 * 也叫做发布订阅模式，属于行为型模式
 * 当一个对象的改变需要同时改变其他的对象，且不知道具体有多少对象有待改变的时候，使用该模式
 */
public class Main {

    public static void main(String[] args){
        // 创建一个主题
        BossConcreteSubject subject = new BossConcreteSubject();

        //创建一个观察者
        Observer myObserver = new MyConcreteObserver();

        //创建一个观察者
        Observer BobObserver = new BobConcreteObserver();

        //主题被观察
        subject.addObserver(myObserver);
        subject.addObserver(BobObserver);

        //主题开始活动，里面通知观察者
        subject.doSomething();

    }

}
