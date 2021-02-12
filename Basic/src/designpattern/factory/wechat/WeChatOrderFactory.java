package designpattern.factory.wechat;

import designpattern.factory.OrderInterface;
import designpattern.factory.PayInterface;
import designpattern.factory.RefundInterface;

public class WeChatOrderFactory implements OrderInterface {

    @Override
    public PayInterface createPay() {
        return new WeChatPay();
    }

    @Override
    public RefundInterface createRefund() {
        return new WeChatRefund();
    }
}
