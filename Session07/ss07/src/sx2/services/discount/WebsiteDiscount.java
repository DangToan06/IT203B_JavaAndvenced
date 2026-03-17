package sx2.services.discount;

import sx2.core.IDiscountStrategy;

import java.io.Console;

public class WebsiteDiscount implements IDiscountStrategy {
    public void apply() { System.out.println("Ap dung ma WEB10: Giam 10%"); }
}
