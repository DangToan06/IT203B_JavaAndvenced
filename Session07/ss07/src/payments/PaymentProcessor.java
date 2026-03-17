package payments;

import payments.itf.PaymentMethod;

public class PaymentProcessor {
    public void execute(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}
