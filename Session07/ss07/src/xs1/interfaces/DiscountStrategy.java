package xs1.interfaces;

public interface DiscountStrategy {
    String getName();
    double applyDiscount(double amount);
}
