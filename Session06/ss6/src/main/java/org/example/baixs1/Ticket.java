package org.example.baixs1;

import java.time.Instant;

public class Ticket {
    private String id;
    private String room;
    private boolean isVIP;
    private boolean isHeld = false;
    private boolean isSold = false;
    private Instant holdExpiryTime;

    public Ticket(String id, String room, boolean isVIP) {
        this.id = id;
        this.room = room;
        this.isVIP = isVIP;
    }

    public String getId() { return id; }
    public boolean isVIP() { return isVIP; }
    public synchronized boolean isAvailable() { return !isHeld && !isSold; }

    public synchronized void hold(int seconds) {
        this.isHeld = true;
        this.holdExpiryTime = Instant.now().plusSeconds(seconds);
    }

    public synchronized void release() {
        this.isHeld = false;
        this.holdExpiryTime = null;
    }

    public synchronized void sell() {
        this.isSold = true;
        this.isHeld = false;
    }

    public synchronized boolean isExpired() {
        return isHeld && holdExpiryTime != null && Instant.now().isAfter(holdExpiryTime);
    }

    @Override
    public String toString() {
        return String.format("Vé %s (Phòng %s%s)", id, room, isVIP ? " - VIP" : "");
    }
}
