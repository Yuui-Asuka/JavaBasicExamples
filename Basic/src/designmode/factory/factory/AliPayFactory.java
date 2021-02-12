package designmode.factory.factory;

import designmode.factory.simplefactory.Pay;
import designmode.factory.simplefactory.AliPay;

public class AliPayFactory implements PayFactory{
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
