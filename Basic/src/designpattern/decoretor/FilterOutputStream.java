package designpattern.decoretor;

public class FilterOutputStream implements OutputStream{


    private String description = " 增加一个过滤装饰器";

    private OutputStream outputStream;

    public FilterOutputStream(OutputStream outputStream){
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
