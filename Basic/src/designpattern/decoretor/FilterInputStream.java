package designpattern.decoretor;

public class FilterInputStream implements InputStream{

    private String description = " 增加一个过滤装饰器";

    private InputStream inputStream;

    public FilterInputStream(InputStream inputStream){
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
