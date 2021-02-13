package designpattern.chain;

/**
 * 第一级风控策略的具体实现类
 */
public class FirstRiskControl extends RiskControlManager{

    public FirstRiskControl(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType()) != null && request.getMoney() < 1000){
            System.out.println("小额直接支付" + " 支付金额: " + request.getMoney());
        } else {
            if (superior != null){
                superior.handlerRequest(request);
            }
        }
    }
}
