package org.example;

public class TicketSupplier implements Runnable {
    private TicketPool a, b;
    public TicketSupplier(TicketPool a, TicketPool b) { this.a = a; this.b = b; }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(2000);
                System.out.println("\n>>> [Nhà cung cấp]: Đang nạp thêm vé...");
                a.addTickets(2);
                b.addTickets(2);
            }
            a.closePool();
            b.closePool();
            System.out.println(">>> [Nhà cung cấp]: Đã hết vé trong kho tổng!\n");
        } catch (InterruptedException e) {}
    }
}