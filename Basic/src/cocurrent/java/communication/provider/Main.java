package cocurrent.java.communication.provider;

public class Main {

    public static void main(String[] args){
        MediumInterface medium = new Medium();
        MediumInterface medium1 = new ConditionMedium();

        /**
         * 产生50个消费者去消费数据
         */
//        for (int i = 0; i < 50; i++) {
//            new Thread(new Consumer(medium)).start();
//            new Thread(new Consumer(medium)).start();
//            new Thread(new Consumer(medium)).start();
//        }
        /**
         * 产生1070个生产者去生产数据
         */
//        for (int i = 0; i < 1070; i++) {
//            new Thread(new Provider(medium)).start();
//            new Thread(new Provider(medium)).start();
//            new Thread(new Provider(medium)).start();
//            new Thread(new Provider(medium)).start();
//        }



        /**
         * 产生50个消费者去消费数据
         */
        for (int i = 0; i < 50; i++) {
            new Thread(new Consumer(medium1)).start();
            new Thread(new Consumer(medium1)).start();
            new Thread(new Consumer(medium1)).start();
        }
        /**
         * 产生60个生产者去生产数据
         */
        for (int i = 0; i < 60; i++) {
            new Thread(new Provider(medium1)).start();
            new Thread(new Provider(medium1)).start();
            new Thread(new Provider(medium1)).start();
            new Thread(new Provider(medium1)).start();
        }

    }
}
