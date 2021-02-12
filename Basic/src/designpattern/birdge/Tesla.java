package designpattern.birdge;

public class Tesla extends Car{

    public Tesla(Color color, Configuration configuration){
        super.setColor(color).setConfiguration(configuration);
    }

    @Override
    public void run() {
        System.out.println(color.useColor()+configuration.useConfiguration()+"特斯拉");
    }
}
