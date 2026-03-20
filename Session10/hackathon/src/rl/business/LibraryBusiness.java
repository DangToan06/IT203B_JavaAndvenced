package rl.business;

import rl.entity.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryBusiness {
    private static LibraryBusiness instance;
    private List<Book> books;

    private LibraryBusiness() {
        this.books = new ArrayList<>();
    }

    public static LibraryBusiness getInstance() {
        if (instance == null) {
            instance = new LibraryBusiness();
        }
        return instance;
    }

    public void displayListBook() {
        if (books.isEmpty()) {
            System.err.println("Danh sách rỗng! Chưa có sách nào trong kho.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-20s | %-15s | %-6s | %-25s | %-12s |\n",
                "Mã ID", "Tên sách", "Tác giả", "Năm XB", "Mô tả", "Trạng thái");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        books.forEach(Book::displayData);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    public void addBook(Scanner scanner) {
        Book newBook = new Book(); // Phải tạo object mới mỗi lần thêm
        newBook.inputData(scanner, books);
        books.add(newBook);
    }

    public void updateBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        String updateId = scanner.nextLine().trim();

        Book bookToUpdate = books.stream()
                .filter(b -> b.getBookId().equals(updateId))
                .findFirst()
                .orElse(null);

        if (bookToUpdate == null) {
            System.err.println("Mã sách không tồn tại!");
            return;
        }

        System.out.println("--- ĐỂ TRỐNG (NHẤN ENTER) NẾU KHÔNG MUỐN CẬP NHẬT TRƯỜNG ĐÓ ---");

        System.out.print("Tên sách mới (" + bookToUpdate.getBookName() + "): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            if (newName.length() >= 5) bookToUpdate.setBookName(newName);
            else System.err.println("Tên sách mới < 5 ký tự nên đã giữ nguyên tên cũ.");
        }

        System.out.print("Tác giả mới (" + bookToUpdate.getAuthor() + "): ");
        String newAuthor = scanner.nextLine().trim();
        if (!newAuthor.isEmpty()) {
            bookToUpdate.setAuthor(newAuthor);
        }

        System.out.print("Năm xuất bản mới (" + bookToUpdate.getYear() + "): ");
        String newYearStr = scanner.nextLine().trim();
        if (!newYearStr.isEmpty()) {
            try {
                int newYear = Integer.parseInt(newYearStr);
                if (newYear > 1900 && newYear <= LocalDateTime.now().getYear()) {
                    bookToUpdate.setYear(newYear);
                } else {
                    System.err.println("Năm không hợp lệ, giữ nguyên năm cũ.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Không phải số, giữ nguyên năm cũ.");
            }
        }

        System.out.print("Mô tả mới (" + bookToUpdate.getDescription() + "): ");
        String newDesc = scanner.nextLine().trim();
        if (!newDesc.isEmpty()) {
            bookToUpdate.setDescription(newDesc);
        }

        System.out.print("Trạng thái mới [true-Trong kho/false-Đang mượn] (" + bookToUpdate.isAvailable() + "): ");
        String newStatusStr = scanner.nextLine().trim().toLowerCase();
        if (!newStatusStr.isEmpty()) {
            if (newStatusStr.equals("true") || newStatusStr.equals("false")) {
                bookToUpdate.setAvailable(Boolean.parseBoolean(newStatusStr));
            } else {
                System.err.println("Trạng thái không hợp lệ, giữ nguyên trạng thái cũ.");
            }
        }
        System.out.println("=> Cập nhật thành công!");
    }

    public void removeBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        String deleteId = scanner.nextLine().trim();

        Book bookToDelete = books.stream()
                .filter(b -> b.getBookId().equals(deleteId))
                .findFirst()
                .orElse(null);

        if (bookToDelete == null) {
            System.err.println("Mã sách không tồn tại!");
            return;
        }

        if (!bookToDelete.isAvailable()) {
            System.err.println("Không thể xóa! Sách này hiện đang được cho mượn.");
        } else {
            books.remove(bookToDelete);
            System.out.println("=> Xóa sách thành công!");
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.print("Nhập từ khóa tìm kiếm (Tên sách/Tác giả): ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        List<Book> result = books.stream()
                .filter(b -> b.getBookName().toLowerCase().contains(keyword) ||
                        b.getAuthor().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy cuốn sách nào khớp với từ khóa.");
        } else {
            System.out.println("Tìm thấy " + result.size() + " kết quả:");
            result.forEach(Book::displayData);
        }
    }

    public void thongKe() {
        long availableCount = books.stream().filter(Book::isAvailable).count();
        long borrowedCount = books.size() - availableCount;

        System.out.println("----- THỐNG KÊ TÌNH TRẠNG SÁCH -----");
        System.out.println("Tổng số sách trong hệ thống: " + books.size());
        System.out.println("- Số sách đang có sẵn trong kho: " + availableCount);
        System.out.println("- Số sách đang được cho mượn: " + borrowedCount);
    }

    public void sortBooksByYearDesc() {
        System.out.println("Danh sách sau khi sắp xếp (Năm xuất bản giảm dần):");
        books.stream()
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .forEach(Book::displayData);
    }
}