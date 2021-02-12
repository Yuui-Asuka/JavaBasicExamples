package designpattern.factory.ali;

import designpattern.factory.PayInterface;

public class AliPay implements PayInterface{

    public void pay(){
        System.out.println("支付宝支付");
    }
}
