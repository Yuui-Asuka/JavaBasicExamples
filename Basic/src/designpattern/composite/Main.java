package designpattern.composite;

/**
 * 组合设计模式，适用于树形结构，例如公司的内部的层级、文件系统等。
 */
public class Main {

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
