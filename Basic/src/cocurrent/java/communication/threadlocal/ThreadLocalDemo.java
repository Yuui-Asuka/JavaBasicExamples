package cocurrent.java.communication.threadlocal;

public class ThreadLocalDemo {
    ThreadLocal<Integer> num = ThreadLocal.withInitial(()->0);

    /**
     * 自增并输出num的值
     */
    public void create(){
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "--------->" + myNum);
        num.set(myNum);
    }

    public static void main(String[] args){
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 0; i < 5; i++){
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    threadLocalDemo.create();
                    try {
                        Thread.sleep(finalI * 1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
