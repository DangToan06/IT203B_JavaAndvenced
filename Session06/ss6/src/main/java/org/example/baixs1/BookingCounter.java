package org.example.baixs1;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;
    private boolean wantVIP;

    public BookingCounter(String name, TicketPool pool, boolean wantVIP) {
        this.name = name;
        this.pool = pool;
        this.wantVIP = wantVIP;
    }

    @Override
    public void run() {
        Ticket ticket = pool.holdTicket(wantVIP);
        if (ticket != null) {
            System.out.println(name + ": Đã giữ " + ticket + ". Vui lòng thanh toán trong 5s.");
            try {
                Thread.sleep(3000);

                if (name.equals("Quầy 2")) Thread.sleep(4000);

                synchronized (ticket) {
                    if (!ticket.isExpired()) {
                        ticket.sell();
                        System.out.println(name + ": Thanh toán THÀNH CÔNG " + ticket.getId());
                    } else {
                        System.out.println(name + ": Thanh toán THẤT BẠI (Quá thời gian) " + ticket.getId());
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println(name + ": Hết vé hoặc vé đang được giữ, vui lòng thử lại sau.");
        }
    }
}
