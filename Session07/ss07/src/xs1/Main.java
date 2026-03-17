package xs1;


import xs1.interfaces.*;
import xs1.model.*;
import xs1.services.*;


import java.util.*;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static OrderRepository repo = new DatabaseOrderRepository();
    private static NotificationService notify = new EmailNotification();
    private static OrderService orderService = new OrderService(repo, notify);
    private static InvoiceGenerator invoiceGen = new InvoiceGenerator();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU QUẢN LÝ ---");
            System.out.println("1. Thêm SP | 2. Thêm Khách | 3. Tạo Đơn | 4. Xem Đơn | 5. Doanh thu | 0. Thoát");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Tên SP: "); String name = sc.nextLine();
                    System.out.print("Giá: "); double price = Double.parseDouble(sc.nextLine());
                    products.add(new Product("SP" + (products.size()+1), name, price));
                    System.out.println("Đã thêm thành công!");
                    break;
                case 3:
                    if (customers.isEmpty() || products.isEmpty()) {
                        System.out.println("Cần có khách hàng và sản phẩm trước!");
                        break;
                    }
                    Order order = new Order("ORD" + System.currentTimeMillis(), customers.get(0));
                    order.addProduct(products.get(0), 1);

                    DiscountStrategy discount = new PercentageDiscount(10);
                    PaymentMethod payment = new CreditCardPayment();

                    orderService.processOrder(order, discount, payment);
                    invoiceGen.generate(order);
                    break;
                case 5:
                    double totalRevenue = repo.findAll().stream().mapToDouble(Order::getFinalAmount).sum();
                    System.out.println("Tổng doanh thu: " + String.format("%,.0f VNĐ", totalRevenue));
                    break;
                case 0: return;
            }
        }
    }
}
