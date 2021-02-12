package designpattern.factory;

/**
 * 保证使用方使用同一个产品族的功能
 */
public interface OrderInterface {

    public PayInterface createPay();

    public RefundInterface createRefund();

}
