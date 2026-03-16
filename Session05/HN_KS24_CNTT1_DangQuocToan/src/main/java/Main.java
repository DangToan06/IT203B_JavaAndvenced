import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Product> products;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InvalidProductException {

        int choice;

        do{
            Menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    InvalidProductException.createProduct();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Đóng hệ thống");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                    break;
            }
        }while (choice != 5);
    }

    public static void Menu(){
        System.out.println("========== PRODUCT MANAGEMENT SYSTEM ==========");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Cập nhật số lượng theo id");
        System.out.println("4. Xóa sản phẩm đã hết hàng");
        System.out.println("5. Thoát chưởng trình");
        System.out.println("===============================================");
        System.out.println("Nhập lựa chon của bạn: ");
    }

}