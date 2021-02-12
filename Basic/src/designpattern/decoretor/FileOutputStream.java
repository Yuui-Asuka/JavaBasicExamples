package designpattern.decoretor;


/**
 * 具体的被装饰者
 */
public class FileOutputStream implements OutputStream{



    @Override
    public String read(int length) {
        return "文件读入" + length + "字节";
    }

    @Override
    public String readLine(int length) {
        return "文件按行读" + length + "字节";
    }
}
