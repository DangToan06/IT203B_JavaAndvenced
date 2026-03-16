package org.example;

import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool poolA, poolB;
    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String name, TicketPool a, TicketPool b) {
        this.counterName = name; this.poolA = a; this.poolB = b;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(counterName);
        try {
            while (true) {
                int action = random.nextInt(3);

                if (action == 0) {
                    processSale(poolA.sellTicket());
                } else if (action == 1) {
                    processSale(poolB.sellTicket());
                } else {
                    sellCombo();
                }

                if (poolA.getRemainingTickets() == 0 && poolB.getRemainingTickets() == 0) break;
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(counterName + " dừng.");
        }
    }

    private void processSale(Ticket t) {
        if (t != null) {
            soldCount++;
            System.out.println(counterName + " đã bán vé lẻ: " + t.getTicketId());
        }
    }

    private void sellCombo() {
        synchronized (poolA) {
            synchronized (poolB) {
                Ticket tA = poolA.sellTicketNoWait();
                Ticket tB = poolB.sellTicketNoWait();

                if (tA != null && tB != null) {
                    soldCount += 2;
                    System.out.println(counterName + " [COMBO] thành công: " + tA.getTicketId() + " & " + tB.getTicketId());
                } else {
                    if (tA != null) poolA.returnTicket(tA);
                    if (tB != null) poolB.returnTicket(tB);
                }
            }
        }
    }

    public int getSoldCount() { return soldCount; }
}