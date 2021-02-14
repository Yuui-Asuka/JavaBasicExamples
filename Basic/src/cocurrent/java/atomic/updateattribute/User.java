package cocurrent.java.atomic.updateattribute;

public class User {
    // 原子更新的字段必须用volatile关键字修饰,线程之间共享变量的时候可以保证其立即可见
    volatile long id;
    volatile String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
