package cocurrent.java.containter;

import java.util.Iterator;
import java.util.Vector;

/**
 * 使用Iterator迭代器或者使用forEach遍历容器，迭代过程中会抛出CME异常，
 * 如果要避免该异常，则迭代过程中要持有容器的锁，但是如果容器较大，迭代时间也会较长，
 * 那么访问容器的其他线程将会长时间等待，极大地降低性能
 */
public class Synchronization {

    public static void test() {

        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++){
            stringVector.add("demo" + i);
        }
        //错误的迭代，会引发CME错误
        stringVector.forEach(e -> {
            if (e.equals("demo3")) {
                stringVector.remove(e);
            }
        });
    }

    public static void test2(){
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++){
            stringVector.add("demo" + i);
        }
        //正确的迭代
        Iterator<String> stringIterator = stringVector.iterator();
        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            if (next.equals("demo2")){
                stringIterator.remove();
            }
        }
    }

    public static void test3(){
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++){
            stringVector.add("demo" + i);
        }
        Iterator<String> stringIterator = stringVector.iterator();
        //多线程下迭代会出错，因为当多个线程进入if判断之后，第一个线程已经把demo2删除了，
        //此时另一个线程执行remove操作时会引发异常
        for (int i = 0; i < 10; i++){
        new Thread(()->{
            while (stringIterator.hasNext()){
                String next = stringIterator.next();
                if (next.equals("demo2")){
                    stringIterator.remove();
                }
            }
        }).start();
    }}


    public static void test4(){
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++){
            stringVector.add("demo" + i);
        }
        Iterator<String> stringIterator = stringVector.iterator();
        //加锁之后异常消除
        for (int i = 0; i < 4; i++){
            new Thread(()->{
                synchronized (stringIterator){
                while (stringIterator.hasNext()){
                    String next = stringIterator.next();
                    if (next.equals("demo2")) {
                        stringIterator.remove();
                    }
                    }
                }
            }).start();
        }}



}
