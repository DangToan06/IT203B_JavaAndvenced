package rl.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private int year;
    private String description;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String bookId, String bookName, String author, int year, String description, boolean isAvailable) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void inputData(Scanner scanner, List<Book> existingBooks) {
        while (true) {
            System.out.print("Nhập mã sách (Bxxx): ");
            this.bookId = scanner.nextLine().trim();
            if (this.bookId.matches("^B\\d{3}$")) {
                boolean isExist = existingBooks.stream().anyMatch(b -> b.getBookId().equals(this.bookId));
                if (isExist) {
                    System.err.println("Mã sách đã tồn tại. Vui lòng nhập lại!");
                } else {
                    break;
                }
            } else {
                System.err.println("Mã sách không hợp lệ (Định dạng: Bxxx, VD: B001)!");
            }
        }

        while (true) {
            System.out.print("Nhập tên sách (>= 5 ký tự): ");
            this.bookName = scanner.nextLine().trim();
            if (this.bookName.length() >= 5) {
                break;
            }
            System.err.println("Tên sách phải có ít nhất 5 ký tự!");
        }

        while (true) {
            System.out.print("Nhập tên tác giả: ");
            this.author = scanner.nextLine().trim();
            if (!this.author.isEmpty()) {
                break;
            }
            System.err.println("Tên tác giả không được để trống!");
        }

        int currentYear = LocalDateTime.now().getYear();
        while (true) {
            System.out.print("Nhập năm xuất bản (1901 - " + currentYear + "): ");
            try {
                this.year = Integer.parseInt(scanner.nextLine().trim());
                if (this.year > 1900 && this.year <= currentYear) {
                    break;
                }
                System.err.println("Năm xuất bản không hợp lệ!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }

        System.out.print("Nhập mô tả ngắn về sách: ");
        this.description = scanner.nextLine().trim();

        while (true) {
            System.out.println("Sách có sẵn trong kho không? (true/false): ");
            String status = scanner.nextLine().trim().toLowerCase();
            if (status.equals("true") || status.equals("false")) {
                this.isAvailable = Boolean.parseBoolean(status);
                break;
            }
            System.err.println("Vui lòng chỉ nhập 'true' hoặc 'false'!");
        }
    }

    public void displayData() {
        System.out.printf("| %-6s | %-20s | %-15s | %-6d | %-25s | %-12s |\n",
                bookId, bookName, author, year, description, (isAvailable ? "Trong kho" : "Đang mượn"));
    }
}