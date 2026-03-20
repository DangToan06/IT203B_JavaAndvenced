package org.example.luyenTap1;

import org.example.luyenTap1.exception.InsufficientFundsException;
import org.example.luyenTap1.exception.InvalidStockCodeException;
import org.example.luyenTap1.exception.TradingException;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradingService {
    public void executeTrade(StockServerConnection conn, String stock, int quantity, double price, double balance) throws TradingException, IOException{
        String regex = "^[A-Z]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stock);

        if(balance < (quantity * price)) {
            throw new InsufficientFundsException("Balance is insufficient");
        }

        if(!matcher.matches()){
            throw new InvalidStockCodeException("Invalid stock code");
        }

       conn.sendOrder(stock,quantity);

    }
}
