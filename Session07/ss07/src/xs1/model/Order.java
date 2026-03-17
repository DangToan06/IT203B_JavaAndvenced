package xs1.model;

import java.util.*;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items = new HashMap<>();
    private double totalAmount;
    private double finalAmount;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product p, int quantity) { items.put(p, quantity); }
    public Map<Product, Integer> getItems() { return items; }
    public Customer getCustomer() { return customer; }
    public String getOrderId() { return orderId; }
    public void setTotalAmount(double total) { this.totalAmount = total; }
    public double getTotalAmount() { return totalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }
    public double getFinalAmount() { return finalAmount; }
}
