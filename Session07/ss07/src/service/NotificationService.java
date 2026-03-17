package service;

import model.Order;

public interface NotificationService {
    void sendConfirmation(Order order);
}
