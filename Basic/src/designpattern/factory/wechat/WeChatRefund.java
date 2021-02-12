package designpattern.factory.wechat;

import designpattern.factory.RefundInterface;

public class WeChatRefund implements RefundInterface {
    @Override
    public void refund() {
        System.out.println("微信退款");
    }
}
