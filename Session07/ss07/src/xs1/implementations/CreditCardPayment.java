package xs1.implementations;

import xs1.interfaces.PaymentMethod;

class CreditCardPayment implements PaymentMethod {
    public String getName() { return "Thẻ tín dụng"; }
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán Thẻ tín dụng: " + String.format("%,.0f VNĐ", amount));
    }
}
