package designpattern.decorator;

/**
 * 具体的被装饰者
 */
public class ByteOutputStream implements OutputStream{

    @Override
    public String read(int length) {
        return "字节读入" + length + "字节";
    }

    @Override
    public String readLine(int length) {
        return "字节读入" + length + "字节";
    }
}
