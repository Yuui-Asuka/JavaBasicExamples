package designpattern.chain;

/**
 * 第三级风控策略的具体实现类
 */
public class ThirdRiskControl extends RiskControlManager{
    public ThirdRiskControl(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType()) != null && request.getMoney() > 10000) {
            System.out.println("支付数额较大，请进行指纹验证" +"支付金额： " + request.getMoney());
        } else {
            if (superior != null) {
                superior.handlerRequest(request);
            }
        }
    }
    }
