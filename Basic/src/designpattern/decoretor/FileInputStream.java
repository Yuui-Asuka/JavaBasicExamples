package designpattern.decoretor;


/**
 * 具体的被装饰者
 */
public class FileInputStream implements InputStream{

    @Override
    public String write(int length) {
        return "文件读入" + length + "字节";
    }

    @Override
    public String writeLine(int length) {
        return "文件按行读入" + length + "字节";
    }
}
