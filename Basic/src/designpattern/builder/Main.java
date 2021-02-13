package designpattern.builder;

/**
 * 建造器设计模式
 */
public class Main {
    public static void main(String[] args){
        Director director = new Director();
        HttpHeader requestHeader = director.create(new RequestHeader());
        HttpHeader postHeader = director.create(new PostHeader());
        System.out.println(requestHeader.toString());
        System.out.println(postHeader.toString());
    }
}
