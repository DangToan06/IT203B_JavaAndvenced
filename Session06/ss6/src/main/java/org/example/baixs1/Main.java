package org.example.baixs1;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool poolA = new TicketPool("A", 10);
        List<TicketPool> allPools = Collections.singletonList(poolA);

        Thread timeoutThread = new Thread(new TimeoutManager(allPools));
        timeoutThread.setDaemon(true);
        timeoutThread.start();

        System.out.println("--- BẮT ĐẦU HỆ THỐNG ĐẶT VÉ ---");

        Thread q1 = new Thread(new BookingCounter("Quầy 1", poolA, true));
        q1.start();

        Thread.sleep(1000);

        Thread q2 = new Thread(new BookingCounter("Quầy 2", poolA, false));
        q2.start();

        q1.join();
        q2.join();

        Thread.sleep(2000);
        Thread q3 = new Thread(new BookingCounter("Quầy 3", poolA, false));
        q3.start();
        q3.join();

        System.out.println("--- KẾT THÚC PHIÊN GIAO DỊCH ---");
    }
}