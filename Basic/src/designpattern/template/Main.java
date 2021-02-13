package designpattern.template;

/**
 * 模板设计模式
 * 优点： 扩展性好，对不变的代码进行封装，对可变的进行扩展，符合开闭原则
 * 提高代码的复用性，将相同的部分的代码放在抽象的父类中，将不同的代码放入不同的子类中
 * 通过一个父类调用其子类的操作，通过对子类的具体实现扩展不同的行为，实现了反向控制
 */
public class Main {
    public static void main(String[] args) {

        Clean clean = new CleanAdapter();
        Build build = new BuildAdapter();
        Site site = new SiteAdapter();

        SpringBootMaven springBootMaven = new SpringBootMaven(clean, build);
        springBootMaven.mavenLife();

        J2EEMaven j2EEMaven = new J2EEMaven(clean, build, site);
        j2EEMaven.mavenLife();

    }

}
