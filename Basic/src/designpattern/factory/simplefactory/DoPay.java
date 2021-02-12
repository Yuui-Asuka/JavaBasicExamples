package designpattern.factory.simplefactory;

public class DoPay {
    Pay pay = SimplePayFactory.createPay("WECHAT_PAY");
    Object a = pay.unifiedOrder();
}
