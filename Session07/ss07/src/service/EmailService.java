package service;

import model.Order;

public class EmailService implements NotificationService {
    public void sendConfirmation(Order order) {
        System.out.println("Đã gửi email đến " + order.getCustomer().getCustomerEmail() +
                ": Đơn hàng " + order.getOrderId() + " đã được tạo.");
    }
}
