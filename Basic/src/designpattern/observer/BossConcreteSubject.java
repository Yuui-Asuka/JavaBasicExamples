package designpattern.observer;

public class BossConcreteSubject extends Subject{
    public void doSomething(){
        System.out.println("老板完成自己的工作");
        System.out.println("视察公司工作情况");
        super.notifyAllObserver();
    }


}
