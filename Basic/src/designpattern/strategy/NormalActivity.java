package designpattern.strategy;

public class NormalActivity extends Strategy{
    @Override
    public double computePrice(ProductOrder productOrder) {
        return productOrder.getOldPrice();
    }
}
