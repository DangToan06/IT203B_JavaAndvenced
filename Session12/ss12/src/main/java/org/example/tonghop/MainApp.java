package org.example.tonghop;

import org.example.tonghop.dao.HospitalDAO;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        HospitalDAO dao = new HospitalDAO();
        Scanner sc = new Scanner(System.in);

        // Demo Bước 1
        System.out.print("Nhập ID thuốc cần thêm kho: ");
        int id = sc.nextInt();
        System.out.print("Số lượng thêm: ");
        int qty = sc.nextInt();
        dao.updateMedicineStock(id, qty);

        // Demo Bước 2
        System.out.print("\nNhập giá min: ");
        double min = sc.nextDouble();
        System.out.print("Nhập giá max: ");
        double max = sc.nextDouble();
        dao.findMedicinesByPriceRange(min, max);

        // Demo Bước 3
        System.out.print("\nNhập ID đơn thuốc cần tính tiền: ");
        int pId = sc.nextInt();
        dao.calculatePrescriptionTotal(pId);

        // Demo Bước 4
        System.out.print("\nNhập ngày thống kê (yyyy-MM-dd): ");
        String date = sc.next();
        dao.getDailyRevenue(date);

        sc.close();
    }
}
