package repository;

import model.Order;

public interface OrderRepository {
    void save(Order order);
}
