package xs1.interfaces;

public interface PaymentMethod {
    String getName();
    void processPayment(double amount);
}
