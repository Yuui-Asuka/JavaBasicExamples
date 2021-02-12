package designpattern.factory.factory;

import designpattern.factory.simplefactory.Pay;
import designpattern.factory.simplefactory.WechatPay;

/**
 * 一个工厂类生产实体类，可能会导致实体类过多。
 */
public class WeChatPayFactory implements PayFactory{

    @Override
    public Pay getPay() {
        return new WechatPay();
    }
}
