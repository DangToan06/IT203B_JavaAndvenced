package service;

import model.Order;
import repository.OrderRepository;

public class OrderService {
    private final OrderRepository repository;
    private final NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order) {
        repository.save(order);
        notification.sendConfirmation(order);
    }
}
