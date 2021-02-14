package designpattern.decorator;

public class BufferInputStream implements InputStream{

    private String description = " 增加一个缓冲装饰器";

    private InputStream inputStream;

    public BufferInputStream(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public String write(int length) {
        return inputStream.write(length) + description;
    }

    @Override
    public String writeLine(int length) {
        return inputStream.writeLine(length) + description;
    }
}
