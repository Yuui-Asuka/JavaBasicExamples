package designmode.factory;

public class DoPay {
    Pay pay = SimplePayFactory.createPay("WECHAT_PAY");
    Object a = pay.unifiedOrder();
}
