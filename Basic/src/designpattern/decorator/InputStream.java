package designpattern.decorator;

public interface InputStream {
    String write(int length);

    String writeLine(int length);
}
