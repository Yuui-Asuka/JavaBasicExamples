package designpattern.chain;

/**
 * 第二级风控策略的具体实现类
 */
public class SecondRiskControl extends RiskControlManager{
    public SecondRiskControl(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType()) != null && request.getMoney() > 1000 &&
                request.getMoney() < 10000) {
            System.out.println("请输入支付密码" +" 支付金额： "+ request.getMoney());
        } else {
            if (superior != null) {
                superior.handlerRequest(request);
            }
        }
    }}

