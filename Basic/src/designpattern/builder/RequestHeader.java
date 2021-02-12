package designpattern.builder;

/**
 * request请求的建造者
 */
public class RequestHeader implements Builder{
    private HttpHeader httpHeader = new HttpHeader();

    @Override
    public void buildCookie() {
        httpHeader.setCookie("ffesf");
    }

    @Override
    public void buildProxy() {
        httpHeader.setProxy("sock5");
    }

    @Override
    public void buildTimeout() {
        httpHeader.setTimeout(100);
    }

    @Override
    public void buildReferer() {
        httpHeader.setUserAgent("Chrome");
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
