package designpattern.strategy;

public class VoucherActivity extends Strategy{

    private double voucher;

    public VoucherActivity(double voucher) {
        this.voucher = voucher;
    }

    @Override
    public double computePrice(ProductOrder productOrder) {
        return productOrder.getOldPrice() - voucher;
    }
}
