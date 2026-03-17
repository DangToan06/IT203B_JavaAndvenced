package payments.impl;

import payments.itf.CODPayable;

public class CODPayment implements CODPayable {
    @Override
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán COD: " + String.format("%,.0f", amount) + " VNĐ - Thành công");
    }

    @Override
    public void showDeliveryAddress() {
        System.out.println("Đang hiển thị địa chỉ giao hàng...");
    }
}
