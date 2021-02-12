package designmode.factory.factory;

import designmode.factory.simplefactory.Pay;
import designmode.factory.simplefactory.WechatPay;

public class WeChatPayFactory implements PayFactory{

    @Override
    public Pay getPay() {
        return new WechatPay();
    }
}
