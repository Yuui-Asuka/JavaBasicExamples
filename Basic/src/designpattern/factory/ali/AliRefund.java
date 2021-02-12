package designpattern.factory.ali;

import designpattern.factory.RefundInterface;

public class AliRefund implements RefundInterface{

    public void refund() {
        System.out.println("支付宝退款");
    }
}