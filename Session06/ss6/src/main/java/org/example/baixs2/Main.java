package org.example.baixs2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinemaSystem system = CinemaSystem.getInstance();

        while (true) {
            System.out.println("\n--- MENU RẠP CHIẾU PHIM ---");
            System.out.println("1. Bắt đầu mô phỏng\n2. Tạm dừng\n3. Tiếp tục\n4. Thêm vé (phòng)\n5. Xem thống kê\n6. Phát hiện deadlock\n7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Số phòng: "); int r = sc.nextInt();
                    System.out.print("Số vé/phòng: "); int v = sc.nextInt();
                    System.out.print("Số quầy: "); int c = sc.nextInt();
                    system.init(r, v, c);
                    system.startSimulation(c);
                    break;
                case 2:
                    system.setPaused(true);
                    System.out.println("Đã tạm dừng mô phỏng.");
                    break;
                case 3:
                    system.setPaused(false);
                    System.out.println("Đã tiếp tục mô phỏng.");
                    break;
                case 5:
                    system.showStats();
                    break;
                case 6:
                    DeadlockDetector.checkDeadlock();
                    break;
                case 7:
                    system.stopAll();
                    System.out.println("Đang dừng hệ thống... Kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}