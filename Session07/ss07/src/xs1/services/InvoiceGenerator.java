package xs1.services;

import xs1.model.Order;

public class InvoiceGenerator {
    public void generate(Order order) {
        System.out.println("\n=== HÓA ĐƠN ===");
        System.out.println("Khách hàng: " + order.getCustomer().getName());
        order.getItems().forEach((p, q) -> {
            System.out.println(p.getName() + " - SL: " + q + " - Đơn giá: " + String.format("%,.0f", p.getPrice()));
        });
        System.out.println("Tổng tiền: " + String.format("%,.0f VNĐ", order.getTotalAmount()));
        System.out.println("Cần thanh toán: " + String.format("%,.0f VNĐ", order.getFinalAmount()));
    }
}
