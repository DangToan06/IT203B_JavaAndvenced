package org.example.baixs2;

public class Ticket {
    private String id;
    private double price;
    private boolean isSold = false;

    public Ticket(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public synchronized boolean sell() {
        if (!isSold) {
            isSold = true;
            return true;
        }
        return false;
    }

    public double getPrice() { return price; }
    public String getId() { return id; }
}
