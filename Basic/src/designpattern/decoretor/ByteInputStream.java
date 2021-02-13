package designpattern.decoretor;

/**
 * 具体的被装饰者
 */
public class ByteInputStream implements InputStream{
    @Override
    public String write(int length) {
        return "字节写入" + length + "字节";
    }

    @Override
    public String writeLine(int length) {
        return "字节按行写入" + length + "字节";
    }
}
