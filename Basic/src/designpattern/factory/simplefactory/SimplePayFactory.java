package designpattern.factory.simplefactory;

/**
 * 生产产品的工厂 返回实例
 */
public class SimplePayFactory {

    public static Pay createPay(String payType){
        if (payType == null){
            return null;
        } else if(payType.equalsIgnoreCase("WECHAT_PAY")){
            return new WechatPay();
        } else if (payType.equalsIgnoreCase(("ALI_PAY"))){
            return new AliPay();
        }
        return null;

    }
}
