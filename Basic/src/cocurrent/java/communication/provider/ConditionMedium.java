package cocurrent.java.communication.provider;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于wait和notify的改进：
 * wait和notify必须放在同步代码块中(即需要由synchronized关键字锁定)
 * 且必须拥有当前对象的锁，不能取得A对象的锁，调用B对象的wait
 * 哪个对象wait，就要调用哪个对象的notify
 * 使用condition,可以在一个锁里面存在多种等待条件
 */
public class ConditionMedium implements MediumInterface{

    /**
     * 默认的同步信号量为0
     */
    private int num = 0;

    /**
     * 缓存区容量
     */
    private static final int CONTENT = 65535;

    private Lock lock = new ReentrantLock();
    private Condition consumerCondition = lock.newCondition();
    private Condition producerCondition = lock.newCondition();

    /**
     * 不需要使用synchronized关键字
     */
    public void put(){
        lock.lock();
        try {
            if (num < CONTENT) {
                //如果不是，生产完成之后，通知消费者进行消费
                System.out.println("新增容量----------->当前容量" + ++num);
                //唤醒所有的消费者
                consumerCondition.signalAll();
            } else {
                //如果是，则通知生产者进行等待
                try {
                    System.out.println("新增容量----------->缓冲池已满" + num);
                    //生产者进行等待
                    producerCondition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    /**
     * 获取消费数据
     */
    public void take(){
        //判断当前库存是否不足
        lock.lock();
        try {
        if(num > 0){
            System.out.println("消费数据--------------> 当前缓冲区容量" + --num);
            //通知生产者进行生产
            producerCondition.signalAll();
        } else {
            try {
                //消费者暂停消费
                consumerCondition.await();
                System.out.println("消费数据---------------> 库存不足" + num);
            }catch (Exception e){
                e.printStackTrace();
            }
        }}catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.lock();
        }

    }

}
