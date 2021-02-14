package designpattern.decorator;

public class BufferOutputStream implements OutputStream{

    private String description = " 增加一个缓冲装饰器";

    private OutputStream outputStream;

    public BufferOutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public String read(int length) {
        return outputStream.read(length) + description;
    }

    @Override
    public String readLine(int length) {
        return outputStream.readLine(length) + description;
    }
}
