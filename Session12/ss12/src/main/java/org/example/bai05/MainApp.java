package org.example.bai05;
import org.example.bai05.dao.PatientDAO;
import org.example.bai05.model.Patient;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ NỘI TRÚ RHMS ---");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án (Khoa điều trị)");
            System.out.println("4. Xuất viện & Tính phí");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.println(String.format("| %-10s | %-20s | %-5s | %-20s |", "Mã BN", "Họ Tên", "Tuổi", "Khoa"));
                        dao.getAllPatients().forEach(System.out::println);
                        break;
                    case 2:
                        System.out.print("Mã BN: "); String id = sc.nextLine();
                        System.out.print("Tên (VD: L'Oréal): "); String name = sc.nextLine();
                        System.out.print("Tuổi: "); int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Khoa: "); String dept = sc.nextLine();
                        dao.addPatient(new Patient(id, name, age, dept, null));
                        System.out.println("Tiếp nhận thành công!");
                        break;
                    case 3:
                        System.out.print("Nhập mã BN cần cập nhật: "); String uId = sc.nextLine();
                        System.out.print("Khoa điều trị mới: "); String uDept = sc.nextLine();
                        dao.updateDepartment(uId, uDept);
                        System.out.println("Cập nhật thành công!");
                        break;
                    case 4:
                        System.out.print("Nhập mã BN xuất viện: "); String dId = sc.nextLine();
                        double fee = dao.calculateFee(dId);
                        System.out.println("Tổng viện phí cần thanh toán: " + String.format("%,.0f", fee) + " VNĐ");
                        break;
                    case 5:
                        System.out.println("Tạm biệt!");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }
}