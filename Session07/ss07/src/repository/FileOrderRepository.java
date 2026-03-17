package repository;

import model.Order;

public class FileOrderRepository implements  OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng " + order.getOrderId() + " vào cơ sở dữ liệu.");
    }

    public Order findById(String id) {
        return null;
    }
}
