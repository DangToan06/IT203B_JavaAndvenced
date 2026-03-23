package org.example.business;

import org.example.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseBusiness {
    private static  CourseBusiness instance;
    private List<Course> courses;

    private CourseBusiness() {
        courses = new ArrayList<>();
    }

    public static CourseBusiness getInstance() {
        if (instance == null) {
            instance = new CourseBusiness();
        }
        return instance;
    }

    private void displayTableHeader() {
        System.out.println("+---------+---------------------------+---------+--------------+----------------------+------------+");
        System.out.printf("| %-7s | %-25s | %-7s | %-12s | %-20s | %-10s |\n",
                "Mã KH", "Tên khóa học", "Tín chỉ", "Học phí", "Giảng viên", "Trạng thái");
        System.out.println("+---------+---------------------------+---------+--------------+----------------------+------------+");
    }

    private void displayTableFooter() {
        System.out.println("+---------+---------------------------+---------+--------------+----------------------+------------+");
    }

    public void displayAll() {
        if (courses.isEmpty()) {
            System.err.println("Danh sách khóa học hiện đang rỗng.");
            return;
        }
        displayTableHeader();
        courses.forEach(Course::displayData);
        displayTableFooter();
    }

    public void addCourse(Scanner scanner){
        Course course = new Course();

        while (true) {
            System.out.print("Nhập mã khóa học (CO + 3 số): ");
            String id = scanner.nextLine().trim();
            if (id.matches("^CO\\d{3}$")) {
                boolean isExist = courses.stream().anyMatch(c -> c.getCourseId().equals(id));
                if (isExist) {
                    System.err.println("Mã khóa học đã tồn tại. Vui lòng nhập lại!");
                } else {
                    course.setCourseId(id);
                    break;
                }
            } else {
                System.err.println("Mã khóa học không hợp lệ (vd: CO001).");
            }
        }
        course.inputData(scanner);
        courses.add(course);
        System.out.println("Thêm khóa học thành công!");
    }

    public void updateCourse(String id, Scanner scanner) {
        Optional<Course> optionalCourse = courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst();

        if (!optionalCourse.isPresent()) {
            System.err.println("Mã khóa học không tồn tại");
            return;
        }

        Course course = optionalCourse.get();
        System.out.println("--- Cập nhật thông tin (Nhấn Enter để bỏ qua trường không muốn đổi) ---");

        System.out.printf("1. Tên khóa học cũ (%s): ", course.getCourseName());
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            if (name.length() >= 5) course.setCourseName(name);
            else System.err.println("Tên < 5 ký tự. Giữ nguyên tên cũ.");
        }

        System.out.printf("2. Số tín chỉ cũ (%d): ", course.getCredit());
        String creditStr = scanner.nextLine().trim();
        if (!creditStr.isEmpty()) {
            try {
                int cred = Integer.parseInt(creditStr);
                if (cred > 0 && cred < 10) course.setCredit(cred);
                else System.err.println("Số tín chỉ không hợp lệ. Giữ nguyên tín chỉ cũ.");
            } catch (NumberFormatException e) {
                System.err.println("Lỗi định dạng số. Giữ nguyên tín chỉ cũ.");
            }
        }

        System.out.printf("3. Học phí cũ (%.0f): ", course.getTuitionFee());
        String feeStr = scanner.nextLine().trim();
        if (!feeStr.isEmpty()) {
            try {
                double fee = Double.parseDouble(feeStr);
                if (fee > 0) course.setTuitionFee(fee);
                else System.err.println("Học phí phải > 0. Giữ nguyên học phí cũ.");
            } catch (NumberFormatException e) {
                System.err.println("Lỗi định dạng số. Giữ nguyên học phí cũ.");
            }
        }

        System.out.printf("4. Giảng viên cũ (%s): ", course.getInstructor());
        String inst = scanner.nextLine().trim();
        if (!inst.isEmpty()) {
            course.setInstructor(inst);
        }

        System.out.printf("5. Trạng thái cũ (%s - Nhập true/false): ", course.isStatus() ? "Đang mở" : "Đã đóng");
        String stat = scanner.nextLine().trim().toLowerCase();
        if (!stat.isEmpty()) {
            if (stat.equals("true") || stat.equals("false")) {
                course.setStatus(Boolean.parseBoolean(stat));
            } else {
                System.err.println("Trạng thái không hợp lệ. Giữ nguyên trạng thái cũ.");
            }
        }

        System.out.println("Cập nhật thông tin khóa học thành công!");
    }

    public void deleteCourse(String id) {
        Optional<Course> optionalCourse = courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst();

        if (optionalCourse.isPresent()) {
            courses.remove(optionalCourse.get());
            System.out.println("Xóa khóa học thành công!");
        } else {
            System.err.println("Mã khóa học không tồn tại");
        }
    }

    public void searchByInstructor(String keyword) {
        List<Course> result = courses.stream()
                .filter(c -> c.getInstructor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy khóa học nào của giảng viên chứa từ khóa: " + keyword);
        } else {
            System.out.println("Tìm thấy " + result.size() + " khóa học:");
            displayTableHeader();
            result.forEach(Course::displayData);
            displayTableFooter();
        }
    }

    public void sortByFeeDesc() {
        if (courses.isEmpty()) {
            System.err.println("Danh sách khóa học hiện đang rỗng.");
            return;
        }
        System.out.println("--- Danh sách khóa học sắp xếp theo học phí giảm dần ---");
        displayTableHeader();
        courses.stream()
                .sorted((c1, c2) -> Double.compare(c2.getTuitionFee(), c1.getTuitionFee()))
                .forEach(Course::displayData);
        displayTableFooter();
    }

    public void filterActiveCourses() {
        List<Course> activeCourses = courses.stream()
                .filter(Course::isStatus)
                .collect(Collectors.toList());

        if (activeCourses.isEmpty()) {
            System.out.println("Hiện không có khóa học nào đang mở.");
        } else {
            System.out.println("--- Danh sách các khóa học đang mở ---");
            displayTableHeader();
            activeCourses.forEach(Course::displayData);
            displayTableFooter();
        }
    }
}
