package org.example;

public class Main {
    static void main() throws InterruptedException {
        TicketPool poolA = new TicketPool("A", 5);
        TicketPool poolB = new TicketPool("B", 5);

        BookingCounter c1 = new BookingCounter("Quầy 1", poolA, poolB);
        BookingCounter c2 = new BookingCounter("Quầy 2", poolA, poolB);
        TicketSupplier supplier = new TicketSupplier(poolA, poolB);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread ts = new Thread(supplier);

        System.out.println("=== RẠP CHIẾU PHIM MỞ CỬA ===\n");

        t1.start();
        t2.start();
        ts.start();

        t1.join();
        t2.join();
        ts.join();

        System.out.println("\n=== TỔNG KẾT CUỐI NGÀY ===");
        System.out.println("Quầy 1 bán: " + c1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán: " + c2.getSoldCount() + " vé");
        System.out.println("Phòng A còn lại: " + poolA.getRemainingTickets());
        System.out.println("Phòng B còn lại: " + poolB.getRemainingTickets());
    }

}
