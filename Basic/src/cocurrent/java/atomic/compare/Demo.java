package cocurrent.java.atomic.compare;

import java.util.concurrent.atomic.LongAccumulator;

public class Demo {
    public static void main(String[] args){
        LongAccumulator longAccumulator = new LongAccumulator((left, right)->
            //输入一个数字，如果比上一个输入的大，则直接返回，如果小则返回上一个
            left > right ? left : right, 0L);
        longAccumulator.accumulate(3L);
        System.out.println(longAccumulator.get());
    }
}
