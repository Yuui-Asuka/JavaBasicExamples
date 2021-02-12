package designpattern.builder;

/**
 * 使用相同的创建过程创建不同的产品
 * 将产品和创建过程解耦 使用相同的创建过程创建不同的产品，控制产品生产过程
 */
public class Director {

    public HttpHeader create(Builder builder){
        builder.buildCookie();
        builder.buildProxy();
        builder.buildReferer();
        builder.buildTimeout();
        builder.buildUserAgent();
        return builder.createHttpHeader();
    }

    /**
     * 链式调用的方法
     * @return
     */
    public HttpHeader create2(){
        return  new HttpHeader()
                .setCookie("FE")
                .setReferer("www.google.com")
                .setProxy("sock")
                .setTimeout(100)
                .setUserAgent("firefox").build();
    }
}
