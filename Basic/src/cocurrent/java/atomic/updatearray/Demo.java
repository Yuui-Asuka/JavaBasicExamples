package cocurrent.java.atomic.updatearray;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo {
    public static void main(String[] args){
        int[] arr = new int[]{3, 2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        //数组index=1的值2 + 8 = 10
        System.out.println(atomicIntegerArray.addAndGet(1, 8));
        //数组index=0的值3 * 2 / 3 = 2
        System.out.println(atomicIntegerArray.accumulateAndGet(0, 2, (left, right) ->
                left * right / 3
                ));

    }
}
