package designpattern.factory.simplefactory;

public class WechatPay implements Pay {
    @Override
    public Object unifiedOrder() {
        return new Object();
    }
}
