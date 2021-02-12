package designpattern.proxy;

public class Proxy implements Developers{

    private Developers realObj = new DevelopersReal();

    @Override
    public void run() {
        realObj.run();
        makeActivity();
        makeCharge();
    }

    private void makeActivity(){
        System.out.println("为代理的游戏上线了一个活动");
    }

    private void makeCharge(){
        System.out.println("开放了充值功能");
    }
}
