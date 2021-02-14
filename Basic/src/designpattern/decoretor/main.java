package designpattern.decoretor;

/**
 * 装饰器设计模式 设计模式不止在Java语言中有应用，在python/Js中也常用
 * 比如Python中的@XXX装饰器
 * 以及Js中的闭包
 */

public class main {
    public static void main(String[] args){
        // 建立一个字节输出流
        InputStream inputStream = new ByteInputStream();

        // 搭配一个缓冲器
        inputStream = new BufferInputStream(inputStream);

        // 搭配一个过滤器
        inputStream = new FilterInputStream(inputStream);

        System.out.println(inputStream.write(15));


        // 建立一个文件输入流
        OutputStream outputStream = new FileOutputStream();
        outputStream = new BufferOutputStream(outputStream);
        outputStream = new FilterOutputStream(outputStream);
        System.out.println(outputStream.readLine(18));

    }
}
