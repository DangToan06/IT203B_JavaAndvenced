package sx2.services.discount;

import sx2.core.IDiscountStrategy;

public class POSDiscount implements IDiscountStrategy {
    public void apply() { System.out.println("Ap dung giam gia theo the thanh vien tai quay"); }
}
