package payments.impl;

import payments.itf.CardPayable;

public class CreditCardPayment implements CardPayable {
    @Override
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + String.format("%,.0f", amount) + " VNĐ - Thành công");
    }

    @Override
    public void validateCard() {
        System.out.println("Đang xác thực thẻ tín dụng...");
    }
}
