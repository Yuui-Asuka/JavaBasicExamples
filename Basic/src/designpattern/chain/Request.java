package designpattern.chain;

public class Request {
    public Request(String requestType, int money) {
        this.requestType = requestType;
        this.money = money;
    }

    public Request() {

    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * 类别
     */
    private String requestType;

    /**
     * 金额
     */
    private int money;

    public String getRequestType(){
        return requestType;
    }

    public int getMoney(){
        return money;
    }



}
