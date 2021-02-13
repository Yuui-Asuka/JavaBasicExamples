package designpattern.template;

/**
 * 模板设计模式
 */
public abstract class MavenLifeCycle {

    /**
     * 每个maven项目都有这三个生命周期
     */
    public final void mavenLife(){
        clean();
        build();
        site();
    }

    /**
     * 每个生命周期都有clean阶段
     */
    public abstract void clean();

    /**
     * 每个生命周期都有build阶段
     */
    public abstract void build();

    /**
     * 抽象方法，由具体的子类实现
     */
    public abstract void site();

}
