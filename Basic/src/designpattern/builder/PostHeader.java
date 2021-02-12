package designpattern.builder;

/**
 * post请求头的建造者
 */
public class PostHeader implements Builder{

    private HttpHeader httpHeader = new HttpHeader();

    @Override
    public void buildCookie() {
        httpHeader.setCookie("ffesdadeef");
    }

    @Override
    public void buildProxy() {
        httpHeader.setProxy("sock4");
    }

    @Override
    public void buildTimeout() {
        httpHeader.setTimeout(190);
    }

    @Override
    public void buildReferer() {
        httpHeader.setUserAgent("FireFox");
    }

    @Override
    public void buildUserAgent() {
        httpHeader.setReferer("https://www.baidu.com");
    }

    @Override
    public HttpHeader createHttpHeader() {
        return httpHeader;
    }
}
