package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TenNgauNhien implements Runnable {
    List<String> ten = new ArrayList<String>(List.of("Duong", "Huy", "Hoang", "Quang"));
    List<String> que = new ArrayList<String>(List.of("Nam Dinh", "Vinh Phuc", "Hai Duong", "Hai Phong"));


    @Override
    public void run() {
        Random random = new Random();

        while (true){
            int randomNumber = random.nextInt(ten.size());
            String tenNgau = ten.get(randomNumber);
            String queNgau = que.get(randomNumber);
            System.out.println(tenNgau + " - " + queNgau);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
