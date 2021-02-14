package cocurrent.java.containter;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentContainer {
    public static void test() {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }
        //抛出异常，因为不支持移除元素
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("demo2")){
                iterator.remove();
            }
        }
    }

    /**
     * 此时不会抛出异常
     */
    public static void test2() {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }
        //抛出异常，因为不支持移除元素
        for (int i = 0; i < 5; i++){
            new Thread(()->{
                strings.forEach(e->{
                    if (e.equals("demo2")){
                        strings.remove(e);
                    }
                });
            }).start();
        }
    }
}
