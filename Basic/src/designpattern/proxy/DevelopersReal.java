package designpattern.proxy;

public class DevelopersReal implements Developers{


    @Override
    public void run() {
        System.out.println("开发了游戏");
    }
}
