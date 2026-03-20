package org.example.entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private  double tuitionFee;
    private String instructor;
    private boolean status;

    public Course() {
    }

    public Course(String courseId, String courseName, int credit, double tuitionFee, String instructor, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.tuitionFee = tuitionFee;
        this.instructor = instructor;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner){
        if (this.courseId == null || this.courseId.isEmpty()) {
            while (true) {
                System.out.print("Nhập mã khóa học (CO + 3 số): ");
                String id = scanner.nextLine().trim();
                if (id.matches("^CO\\d{3}$")) {
                    this.courseId = id;
                    break;
                }
                System.err.println("Sai định dạng! Yêu cầu CO + 3 số (vd: CO001).");
            }
        }

        while (true) {
            System.out.print("Nhập tên khóa học (tối thiểu 5 ký tự): ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty() && name.length() >= 5) {
                this.courseName = name;
                break;
            }
            System.err.println("Tên khóa học không được để trống và phải có tối thiểu 5 ký tự.");
        }

        while (true) {
            System.out.print("Nhập số tín chỉ (0 < tín chỉ < 10): ");
            try{
                int cred = Integer.parseInt(scanner.nextLine().trim());
                if (cred > 0 && cred < 10) {
                    this.credit = cred;
                    break;
                }
                System.err.println("Số tín chỉ phải lớn hơn 0 và nhỏ hơn 10.");
            }catch (NumberFormatException e){
                System.err.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập học phí (VNĐ, > 0): ");
            try{
                double tuitionFee = Double.parseDouble(scanner.nextLine().trim());
                if(tuitionFee > 0){
                    this.tuitionFee = tuitionFee;
                    break;
                }
                System.err.println("Học phí phải lớn hơn 0.");
            }catch (NumberFormatException e){
                System.err.println("Vui lòng nhập một số hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập tên giảng viên phụ trách: ");
            String inst = scanner.nextLine().trim();
            if (!inst.isEmpty()) {
                this.instructor = inst;
                break;
            }
            System.err.println("Tên giảng viên không được để trống.");
        }

        while (true) {
            System.out.print("Nhập trạng thái khóa học (true: Đang mở, false: Đã đóng): ");
            String statStr = scanner.nextLine().trim().toLowerCase();
            if (statStr.equals("true") || statStr.equals("false")) {
                this.status = Boolean.parseBoolean(statStr);
                break;
            }
            System.err.println("Vui lòng chỉ nhập 'true' hoặc 'false'.");
        }

    }

    public void displayData() {
        String statusStr = this.status ? "Đang mở" : "Đã đóng";
        System.out.printf("| %-7s | %-25s | %-7d | %-12.0f | %-20s | %-10s |\n",
                this.courseId, this.courseName, this.credit, this.tuitionFee, this.instructor, statusStr);
    }
}
