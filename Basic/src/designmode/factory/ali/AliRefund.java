package designmode.factory.ali;

import designmode.factory.RefundInterface;

public class AliRefund {

    @Override
    public void refund() {
        System.out.println("支付宝退款");
    }
}