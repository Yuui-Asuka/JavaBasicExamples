package designpattern.factory.wechat;

import designpattern.factory.PayInterface;

public class WeChatPay implements PayInterface {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
