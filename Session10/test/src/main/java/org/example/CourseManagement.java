package org.example;

import org.example.business.CourseBusiness;

import java.util.Scanner;

public class CourseManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseBusiness business = CourseBusiness.getInstance();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n********************* QUẢN LÝ KHÓA HỌC ********************");
            System.out.println("1. Hiển thị danh sách toàn bộ khóa học");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật thông tin khóa học theo mã");
            System.out.println("4. Xóa khóa học theo mã");
            System.out.println("5. Tìm kiếm khóa học theo tên giảng viên");
            System.out.println("6. Lọc khóa học đang mở");
            System.out.println("7. Sắp xếp khóa học theo học phí giảm dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        business.displayAll();
                        break;
                    case 2:
                        boolean isAdding = true;
                        while (isAdding) {
                            business.addCourse(scanner);
                            System.out.print("Bạn có muốn thêm tiếp không? (Y/N): ");
                            String ans = scanner.nextLine().trim();
                            if (!ans.equalsIgnoreCase("y")) {
                                isAdding = false;
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập mã khóa học cần cập nhật: ");
                        String idUpdate = scanner.nextLine().trim();
                        business.updateCourse(idUpdate, scanner);
                        break;
                    case 4:
                        System.out.print("Nhập mã khóa học cần xóa: ");
                        String idDelete = scanner.nextLine().trim();
                        business.deleteCourse(idDelete);
                        break;
                    case 5:
                        System.out.print("Nhập tên giảng viên cần tìm: ");
                        String keyword = scanner.nextLine().trim();
                        business.searchByInstructor(keyword);
                        break;
                    case 6:
                        business.filterActiveCourses();
                        break;
                    case 7:
                        business.sortByFeeDesc();
                        break;
                    case 8:
                        System.out.println("Cảm ơn bạn đã sử dụng phần mềm!");
                        isRunning = false;
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập từ 1 đến 8.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số nguyên tương ứng với menu!");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi hệ thống: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
