package cocurrent.java.atomic.updateattribute;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {
    /**
     * 原子地更新引用字段的值
     * 子类无法修改父类的字段
     * 必须修改实例的属性而不能修改类的属性
     * 如果某个属性用final进行修饰则不能进行更新
     * @param args
     */
    public static void main(String[] args){
        //修改基本类型属性
            AtomicLongFieldUpdater<User> longFieldUpdater =
                    AtomicLongFieldUpdater.newUpdater(User.class, "id");
            User user = new User(1L, "Bob");
            //CAS操作
            longFieldUpdater.compareAndSet(user, 1L, 100L);
            System.out.println(user.getId());

            //修改引用类型属性
        AtomicReferenceFieldUpdater referenceFieldUpdater =
                AtomicReferenceFieldUpdater.newUpdater(User.class, String.class, "name");
        //CAS操作
        referenceFieldUpdater.compareAndSet(user, "Bob", "Cat");
        System.out.println(user.getName());

        //将某一个引用变量更新为另一个引用
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        User user1 = new User(1000L, "Lily");
        userAtomicReference.set(user);
        userAtomicReference.compareAndSet(user, user1);
        User user2 = userAtomicReference.get();
        System.out.println(user2.getName());
    }

}
