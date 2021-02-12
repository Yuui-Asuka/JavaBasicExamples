package designpattern.prototype;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user1 = new User();

        user1.setName("Cris");
        user1.setAge(18);
        user1.getList().add("aaaa");

        User user2 = (User) user1.deepClone();
        user2.setName("Bob");
        user2.setAge(15);
        user2.getList().add("ccc");

        /**
         * 浅拷贝下 只能生成一个新的实例，但是如果原对象的成员变量是一个引用类型，
         * 那么成员变量仍然指向原先的地址。
         */
        System.out.println(user1.getList().hashCode());
        System.out.println(user2.getList().hashCode());


        for (String a: user1.getList()){
            System.out.println(a);
        }

        for (String b: user2.getList()){
            System.out.println(b);
        }

    }

}
