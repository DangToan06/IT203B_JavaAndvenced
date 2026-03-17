package xs1.services;

import xs1.interfaces.DiscountStrategy;
import xs1.interfaces.NotificationService;
import xs1.interfaces.OrderRepository;
import xs1.interfaces.PaymentMethod;
import xs1.model.Order;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void processOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = order.getItems().entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum();
        order.setTotalAmount(total);
        order.setFinalAmount(discount.applyDiscount(total));

        payment.processPayment(order.getFinalAmount());
        repository.save(order);

        notification.send("Đơn hàng " + order.getOrderId() + " đã được tạo", order.getCustomer().getEmail());
    }
}
