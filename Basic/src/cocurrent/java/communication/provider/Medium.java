package cocurrent.java.communication.provider;

import designpattern.birdge.Configuration;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Medium implements MediumInterface{

    /**
     * 默认的同步信号量为0
     */
    private int num = 0;

    /**
     * 缓存区容量
     */
    private static final int CONTENT = 65535;

    /**
     * 接受生产数据
     */
    public synchronized void put(){
        //判断当前的库存，是否已经是最大的库存量
        if (num < CONTENT) {
            //如果不是，生产完成之后，通知消费者进行消费
            System.out.println("新增容量----------->当前容量" + ++num);
            notifyAll();
        } else {
            //如果是，则通知生产者进行等待
            try {
                System.out.println("新增容量----------->缓冲池已满" + num);
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            }
        }

    /**
     * 获取消费数据
     */
    public synchronized void take(){
        //判断当前库存是否不足
        if(num > 0){
            System.out.println("消费数据--------------> 当前缓冲区容量" + --num);
            notifyAll();
        } else {
            System.out.println("消费数据---------------> 库存不足" + num);
        }
    }
}
