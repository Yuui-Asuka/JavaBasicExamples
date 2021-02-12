package designpattern.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable, Serializable{

    private String name;
    private int age;
    private List<String> list = new ArrayList<>();


    public User() {
        System.out.println("调用构造函数");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getList() {
        return list;
    }

    /**
     * clone()是受保护方法，在其他类中，子类的实例不能调用基类的该方法。因此需要由子类去调用然后返回。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public User clone() throws CloneNotSupportedException{
        return (User) super.clone();
    }

    /**
     * 深拷贝
     * @return
     */
    public User deepClone() throws IOException, ClassNotFoundException {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (User) ois.readObject();
        }
    }
