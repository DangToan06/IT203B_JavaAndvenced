package payments.impl;

import payments.itf.EWalletPayable;

public class MomoPayment implements EWalletPayable {
    @Override
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + String.format("%,.0f", amount) + " VNĐ - Thành công");
    }

    @Override
    public void connectToApp() {
        System.out.println("Đang kết nối ứng dụng MoMo...");
    }
}
