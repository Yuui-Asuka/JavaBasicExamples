package cocurrent.java.threadCreate;

public class Create extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}


