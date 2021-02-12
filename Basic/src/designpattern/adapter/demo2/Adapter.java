package designpattern.adapter.demo2;

public class Adapter extends OldModule implements TargetModule{


    @Override
    public void methodA() {
        System.out.println("重写老类的A方法");
    }

    @Override
    public void methodB() {
        System.out.println("新接口的B方法");
    }
}
