package designpattern.builder;

/**
 * 请求头的POJO类
 */
public class HttpHeader{

    private String cookie;

    private String proxy;

    private int timeout;

    private String referer;

    private String userAgent;

//    public static HttpHeader httpBuilder(){
//        return new HttpHeader();
//    }

    public String getCookie() {
        return cookie;
    }

    public String getProxy() {
        return proxy;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public HttpHeader setCookie(String cookie) {
        this.cookie = cookie;
        return this;
    }

    public HttpHeader setProxy(String proxy) {
        this.proxy = proxy;
        return this;
    }

    public HttpHeader setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public HttpHeader setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public HttpHeader setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public HttpHeader build(){
        System.out.println("构建了Http请求头");
        return this;
    }

    @Override
    public String toString() {
        return "RequestHeader{" +
                "cookie='" + cookie + '\'' +
                ", proxy='" + proxy + '\'' +
                ", timeout='" + timeout + '\'' +
                ", referer='" + referer + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }


}
