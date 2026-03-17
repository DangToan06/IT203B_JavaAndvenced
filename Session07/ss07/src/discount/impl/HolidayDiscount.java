package discount.impl;

import discount.DiscountStrategy;

public class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.85;
    }
}
