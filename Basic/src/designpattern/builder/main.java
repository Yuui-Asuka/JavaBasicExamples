package designpattern.builder;

public class main {
    public static void main(String[] args){
        Director director = new Director();
        HttpHeader requestHeader = director.create(new RequestHeader());
        HttpHeader postHeader = director.create(new PostHeader());
        System.out.println(requestHeader.toString());
        System.out.println(postHeader.toString());
    }
}
