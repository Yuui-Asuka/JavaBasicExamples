package designpattern.builder;

public interface Builder {

    void buildCookie();

    void buildProxy();

    void buildTimeout();

    void buildReferer();

    void buildUserAgent();

    HttpHeader createHttpHeader();
}
