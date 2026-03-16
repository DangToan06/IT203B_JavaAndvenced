package org.example.baixs2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CinemaRoom {
    private String name;
    private List<Ticket> tickets = new ArrayList<>();
    private AtomicInteger soldCount = new AtomicInteger(0);

    public CinemaRoom(String name, int capacity, double price) {
        this.name = name;
        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(name + "-" + i, price));
        }
    }

    public Ticket bookNextTicket() {
        for (Ticket t : tickets) {
            if (t.sell()) {
                soldCount.incrementAndGet();
                return t;
            }
        }
        return null;
    }

    public String getName() { return name; }
    public int getSoldCount() { return soldCount.get(); }
    public int getTotalCapacity() { return tickets.size(); }
    public double getRevenue() {
        return soldCount.get() * (tickets.isEmpty() ? 0 : tickets.get(0).getPrice());
    }
}
