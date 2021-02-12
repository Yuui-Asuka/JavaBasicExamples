package designpattern.strategy;

public class PromotionContext {

    private Strategy strategy;

    public  PromotionContext(Strategy strategy){
        this.strategy = strategy;
    }

    public double executeStrategy(ProductOrder productOrder){
        return strategy.computePrice(productOrder);
    }
}
