package calculator;

import discount.DiscountStrategy;
import model.Order;
import model.Product;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(Order order) {
        double total = 0;
        for (Product p : order.getProducts()) {
            total += p.getProductPrice();
        }
        order.setTotalPrice(total);
        return total;
    }

    public double calculateFinalPrice(double totalAmount) {
        if (discountStrategy == null) return totalAmount;
        return discountStrategy.applyDiscount(totalAmount);
    }
}
