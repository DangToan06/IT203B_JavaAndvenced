package org.example.baixs1;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private List<Ticket> tickets = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public TicketPool(String room, int count) {
        for (int i = 1; i <= count; i++) {
            tickets.add(new Ticket(room + "-" + String.format("%03d", i), room, false));
        }
    }

    public Ticket holdTicket(boolean requestVIP) {
        lock.lock();
        try {
            for (Ticket t : tickets) {
                if (t.isAvailable() && (requestVIP == t.isVIP() || !requestVIP)) {
                    t.hold(5); // Giữ trong 5 giây
                    return t;
                }
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void releaseExpiredTickets() {
        lock.lock();
        try {
            for (Ticket t : tickets) {
                if (t.isExpired()) {
                    t.release();
                    System.out.println("[TimeoutManager] " + t.getId() + " hết hạn, đã trả lại kho.");
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void markAsVIP(String ticketId) {
        for (Ticket t : tickets) {
            if (t.getId().equals(ticketId)) {
                return;
            }
        }
    }
}