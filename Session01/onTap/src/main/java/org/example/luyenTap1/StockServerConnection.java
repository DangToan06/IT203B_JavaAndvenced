package org.example.luyenTap1;

import java.io.IOException;

public class StockServerConnection implements AutoCloseable {

    public StockServerConnection() {
        System.out.println("Stock Server Connection");
    }

    @Override
    public void close() {
        System.out.println("Completely disconnected, freeing up bandwidth");
    }

    public void sendOrder(String stock, int quantity) throws IOException {
        if(stock ==  null || quantity == 0){
            throw new IOException("Transmission error");
        }
    }
}
