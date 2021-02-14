package cocurrent.java.lock;

public class Main {
    public static void main(String[] args){
        LockDegrade lockDegrade = new LockDegrade();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lockDegrade.test3();
            }).start();
        }


//        ReadWriteLock readWriteLock = new ReadWriteLock();
//        for (int i = 0; i < 3; i++){
//            new Thread(()->{
//                readWriteLock.inCreate();
//                readWriteLock.out();
//            }, "读写线程").start();
//        }
//        new Thread(()->{
//            readWriteLock.out();
//        }, "读线程").start();
//        new Thread(()->{
//            readWriteLock.inCreate();
//        }, "写线程").start();
    }
}
