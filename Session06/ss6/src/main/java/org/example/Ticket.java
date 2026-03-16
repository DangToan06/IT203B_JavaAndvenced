package org.example;

public class Ticket {
    private String ticketId;
    private String roomName;
    private boolean isSolid;

    public Ticket() {
    }

    public Ticket(String ticketId, String roomName) {
        setTicketId(ticketId);
        setRoomName(roomName);
        this.isSolid = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }
}
