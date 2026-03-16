package org.example;

import java.util.Random;

public class DongBo implements Runnable {
    private int number ;

    public DongBo() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            Thread.sleep(1000);
            setNumber(random.nextInt(100));
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
