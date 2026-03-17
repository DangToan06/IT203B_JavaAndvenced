package sx2.services.discount;

import sx2.core.IDiscountStrategy;

public class MobileDiscount implements IDiscountStrategy {
    public void apply() { System.out.println("Ap dung giam 15% cho lan dau mua tren App"); }
}
