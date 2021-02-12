package designpattern.strategy;

public class ProductOrder {

    private double oldPrice;

    private int userId;

    private int productId;

    public ProductOrder(double oldPrice, int userId, int productId){
        this.oldPrice = oldPrice;
        this.userId = userId;
        this.productId = productId;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
