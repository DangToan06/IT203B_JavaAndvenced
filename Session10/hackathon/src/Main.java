import rl.business.LibraryBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryBusiness libraryBusiness = LibraryBusiness.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n******************** QUẢN LÝ KHO HÀNG ********************");
            System.out.println("1. Hiển thị danh sách toàn bộ sách.");
            System.out.println("2. Thêm mới sách.");
            System.out.println("3. Cập nhật thông tin sách theo mã.");
            System.out.println("4. Xóa sách theo mã.");
            System.out.println("5. Tìm sách theo tên/tác giả.");
            System.out.println("6. Thống kê tình trạng sách (Số lượng sẵn có / Đang mượn).");
            System.out.println("7. Sắp xếp sách theo năm xuất bản giảm dần.");
            System.out.println("8. Thoát.");
            System.out.println("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        libraryBusiness.displayListBook();
                        break;
                    case 2:
                        String conti;
                        do {
                            libraryBusiness.addBook(scanner);
                            System.out.println("=> Thêm sách thành công!");
                            System.out.print("Bạn có muốn tiếp tục thêm không? (Y/N): ");
                            conti = scanner.nextLine().trim();
                        } while (conti.equalsIgnoreCase("Y"));
                        break;
                    case 3:
                        libraryBusiness.updateBook(scanner);
                        break;
                    case 4:
                        libraryBusiness.removeBook(scanner);
                        break;
                    case 5:
                        libraryBusiness.searchBook(scanner);
                        break;
                    case 6:
                        libraryBusiness.thongKe();
                        break;
                    case 7:
                        libraryBusiness.sortBooksByYearDesc();
                        break;
                    case 8:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                        isRunning = false;
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 8.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi không xác định: " + e.getMessage());
            }
        }
        scanner.close();
    }
}