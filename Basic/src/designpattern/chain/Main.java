package designpattern.chain;

/**
 * 责任链设计模式，客户端发出一个请求，链上的对象都有机会来处理这一请求，
 * 客户端不需要知道谁是具体的处理对象
 * 让多个对象都有机会处理请求，避免请求的发送者和接收者之间的耦合关系，将对象连成一个调用链，
 * 并沿着这条链传递该请求，直到有一个对象处理它才终止
 */
public class Main {

    public static void main(String[] args){
        RiskControlManager firstControlManager = new FirstRiskControl("初级风控");
        RiskControlManager secondControlManager = new SecondRiskControl("中级风控");
        RiskControlManager thirdControlManager = new ThirdRiskControl("高级风控");

        //形成调用链
        firstControlManager.setSuperior(secondControlManager);
        secondControlManager.setSuperior(thirdControlManager);

        Request request = new Request();
        request.setRequestType(RequestType.TRANSFER.name());
        request.setMoney(20000);
        firstControlManager.handlerRequest(request);







    }
}
