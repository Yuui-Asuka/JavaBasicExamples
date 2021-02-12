package designpattern.strategy;

public class Main {

    public static void main(String[] args){
        ProductOrder productOrder = new ProductOrder(800, 1, 33);

        PromotionContext context;

        double finalPrice;

        /**
         * 打折情况下的价格
         */
        context = new PromotionContext((new DiscountActivity(0.8)));
        finalPrice = context.executeStrategy(productOrder);
        System.out.println(finalPrice);

        /**
         * 优惠券模式下的价格
         */
        context = new PromotionContext((new VoucherActivity(100)));
        finalPrice = context.executeStrategy(productOrder);
        System.out.println(finalPrice);
    }
}
