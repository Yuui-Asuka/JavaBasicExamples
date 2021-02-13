package cocurrent.java.communication.provider;

public class Main {

    public static void main(String[] args){
        Medium medium = new Medium();
        for (int i = 0; i < 50; i++) {
            new Thread(new Consumer(medium)).start();
            new Thread(new Consumer(medium)).start();
            new Thread(new Consumer(medium)).start();
        }
        for (int i = 0; i < 1070; i++) {
            new Thread(new Provider(medium)).start();
            new Thread(new Provider(medium)).start();
            new Thread(new Provider(medium)).start();
            new Thread(new Provider(medium)).start();
        }

    }
}
