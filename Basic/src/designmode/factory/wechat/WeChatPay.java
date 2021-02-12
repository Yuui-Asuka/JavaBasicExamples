package designmode.factory.wechat;

import designmode.factory.PayFactory;

public class WeChatPayFactory implements PayFactory {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
