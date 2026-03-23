package org.example.bai06.presentation;

import org.example.bai06.dao.DoctorDAO;
import org.example.bai06.model.Doctor;

import java.util.Scanner;

public class RikkeiCareApp {
    public static void main(String[] args) {
        DoctorDAO dao = new DoctorDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- HỆ THỐNG RIKKEI-CARE ---");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        dao.getAllDoctors().forEach(d ->
                                System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty()));
                        break;
                    case 2:
                        System.out.print("Mã BS: "); String id = sc.nextLine();
                        System.out.print("Họ tên: "); String name = sc.nextLine();
                        System.out.print("Chuyên khoa: "); String spec = sc.nextLine();
                        if(dao.addDoctor(new Doctor(id, name, spec))) System.out.println("Thêm thành công!");
                        break;
                    case 3:
                        dao.showStatistics();
                        break;
                    case 4:
                        System.out.println("Tạm biệt!"); return;
                }
            } catch (Exception e) {
                System.err.println("LỖI: " + e.getMessage());
            }
        }
    }
}