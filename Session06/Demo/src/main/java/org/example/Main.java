package org.example;

public class Main {
    static void main() throws InterruptedException {
//        TenNgauNhien name =  new TenNgauNhien();
//
//        Thread t1 = new Thread(name);
//        t1.start();

        DongBo dongBo = new DongBo();

        while (true) {
            Thread thread =  new Thread(dongBo);

            thread.start();

            System.out.println("So duoc sinh ra la: " + dongBo.getNumber());

            thread.join();

            if(dongBo.getNumber() % 2 == 0){
                System.out.println("So chan");
            }else {
                System.out.println("So le");
            }

            Thread.sleep(1000);
        }

    }
}
