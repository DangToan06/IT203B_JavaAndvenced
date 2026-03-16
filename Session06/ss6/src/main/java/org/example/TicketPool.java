package org.example;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int totalCreated = 0;
    private boolean isClosed = false;

    public TicketPool(String roomName, int initialQuantity) {
        this.roomName = roomName;
        addTickets(initialQuantity);
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            totalCreated++;
            tickets.add(new Ticket(String.format("%s-%03d", roomName, totalCreated), roomName));
        }
        notifyAll();
    }

    public synchronized Ticket sellTicket() throws InterruptedException {
        while (!hasAvailableTicket() && !isClosed) {
            System.out.println("   [Hệ thống]: " + Thread.currentThread().getName() + " đang đợi vé phòng " + roomName);
            wait();
        }
        return getOneUnsold();
    }

    public synchronized Ticket sellTicketNoWait() {
        return getOneUnsold();
    }

    public synchronized void returnTicket(Ticket t) {
        if (t != null) {
            t.setSolid(false);
            notifyAll();
        }
    }

    private Ticket getOneUnsold() {
        for (Ticket t : tickets) {
            if (!t.isSolid()) {
                t.setSolid(true);
                return t;
            }
        }
        return null;
    }

    private boolean hasAvailableTicket() {
        for (Ticket t : tickets) {
            if (!t.isSolid()) return true;
        }
        return false;
    }

    public synchronized void closePool() {
        isClosed = true;
        notifyAll();
    }

    public synchronized int getRemainingTickets() {
        int count = 0;
        for (Ticket t : tickets) if (!t.isSolid()) count++;
        return count;
    }

    public String getRoomName() { return roomName; }
}