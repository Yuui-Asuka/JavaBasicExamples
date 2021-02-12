package designmode.factory.wechat;

import designmode.factory.RefundFactory;

public class WeChatRefundFactory implements RefundFactory {
    @Override
    public void refund() {
        System.out.println("微信退款");
    }
}
