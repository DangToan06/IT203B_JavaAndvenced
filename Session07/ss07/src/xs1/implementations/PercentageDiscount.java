package xs1.implementations;

import xs1.interfaces.DiscountStrategy;

class PercentageDiscount implements DiscountStrategy {
    private double pct;
    public PercentageDiscount(double pct) { this.pct = pct; }
    public String getName() { return "Giảm " + pct + "%"; }
    public double applyDiscount(double amount) { return amount * (1 - pct/100); }
}
