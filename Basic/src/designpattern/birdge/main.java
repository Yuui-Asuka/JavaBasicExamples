package designpattern.birdge;

/**
 * 桥接模式用于前期精细化设计，让系统更加灵活
 */
public class main {
    public static void main(String[] args){
        Ferrari ferrari = new Ferrari(new BlueColor(), new HighConfig());
        ferrari.run();

        Tesla tesla = new Tesla(new RedColor(), new LowConfig());
        tesla.run();

    }
}
