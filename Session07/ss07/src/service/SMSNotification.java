package service;

import model.Order;
import repository.OrderRepository;

public class SMSNotification implements NotificationService {

    @Override
    public void sendConfirmation(Order order) {
        System.out.println("Đã gửi email đến " + order.getCustomer().getCustomerEmail() +
                ": Đơn hàng " + order.getOrderId() + " đã được tạo.");
    }
}
