package designpattern.strategy;

/**
 * 策略模式
 * 优点： 满足开闭原则，当增加新的具体策略时，不需要修改上下文类的代码
 * 避免使用多重条件判断，和工厂模式搭配可以消除if-else的多重嵌套
 */
public class DiscountActivity extends Strategy{

    private double rate;

    public DiscountActivity(double rate){
        this.rate = rate;
    }

    @Override
    public double computePrice(ProductOrder productOrder) {
        return productOrder.getOldPrice() * rate;
    }
}
