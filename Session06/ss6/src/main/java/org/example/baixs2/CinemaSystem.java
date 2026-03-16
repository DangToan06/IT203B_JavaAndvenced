package org.example.baixs2;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {
    private static CinemaSystem instance;
    private List<CinemaRoom> rooms = new ArrayList<>();
    private ExecutorService ticketCounters;
    private boolean isPaused = false;
    private final Object pauseLock = new Object();

    private CinemaSystem() {}

    public static CinemaSystem getInstance() {
        if (instance == null) instance = new CinemaSystem();
        return instance;
    }

    public void init(int numRooms, int ticketsPerRoom, int numCounters) {
        rooms.clear();
        for (int i = 0; i < numRooms; i++) {
            rooms.add(new CinemaRoom("Phòng " + (char)('A' + i), ticketsPerRoom, 75000));
        }
        ticketCounters = Executors.newFixedThreadPool(numCounters);
        System.out.println("Đã khởi tạo " + numRooms + " phòng và " + numCounters + " quầy.");
    }

    public void startSimulation(int numCounters) {
        for (int i = 1; i <= numCounters; i++) {
            int counterId = i;
            ticketCounters.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    checkPause();
                    CinemaRoom room = rooms.get(new Random().nextInt(rooms.size()));
                    Ticket t = room.bookNextTicket();

                    if (t != null) {
                        System.out.println("Quầy " + counterId + ": Đã bán vé " + t.getId());
                    }

                    try { Thread.sleep(1500); } catch (InterruptedException e) { break; }
                }
            });
        }
    }

    private void checkPause() {
        synchronized (pauseLock) {
            while (isPaused) {
                try { pauseLock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        }
    }

    public void setPaused(boolean paused) {
        this.isPaused = paused;
        if (!paused) {
            synchronized (pauseLock) { pauseLock.notifyAll(); }
        }
    }

    public void showStats() {
        System.out.println("\n=== THỐNG KÊ HIỆN TẠI ===");
        double totalRevenue = 0;
        for (CinemaRoom r : rooms) {
            System.out.println(r.getName() + ": Đã bán " + r.getSoldCount() + "/" + r.getTotalCapacity());
            totalRevenue += r.getRevenue();
        }
        System.out.println("Tổng doanh thu: " + String.format("%,.0f", totalRevenue) + " VNĐ");
    }

    public void stopAll() {
        if (ticketCounters != null) ticketCounters.shutdownNow();
    }
}
