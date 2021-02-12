package designpattern.factory.ali;

import designpattern.factory.OrderInterface;
import designpattern.factory.PayInterface;
import designpattern.factory.RefundInterface;

/**
 * 订单工厂，实现了订单接口
 */
public class AliOrderFactory implements OrderInterface {

    @Override
    public PayInterface createPay(){
        System.out.println("支付宝订单");
        return new AliPay();
    }

    @Override
    public RefundInterface createRefund(){
        System.out.println("支付宝退款");
        return new AliRefund();
    }
}
