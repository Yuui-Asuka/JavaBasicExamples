package designpattern.birdge;

/**
 * 接口是对行为的抽象，类是对属性的抽象
 */
public class Ferrari extends Car{

    public Ferrari(Color color, Configuration configuration){
        super.setColor(color).setConfiguration(configuration);
    }

    @Override
    public void run() {
        System.out.println(color.useColor()+configuration.useConfiguration()+"法拉利");
    }
}
