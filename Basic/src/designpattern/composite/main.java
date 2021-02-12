package designpattern.composite;

/**
 * 组合设计模式，适用于树形结构
 */
public class main {

    public static void main(String[] args){
        Root root1 = new Folder("C://");

        Root desktop = new Folder("桌面");
        Root myComputer = new Folder("我的电脑");
        Root IeExplore = new Folder("IE浏览器");
        Root javaFile = new File("HelloWorld.java");

        root1.addFile(desktop);
        root1.addFile(myComputer);
        desktop.addFile(IeExplore);
        myComputer.addFile(javaFile);
        root1.display(0);
    }
}
