import calculator.OrderCalculator;
import discount.impl.FixedDiscount;
import discount.impl.HolidayDiscount;
import discount.impl.NoDiscount;
import discount.impl.PercentageDiscount;
import model.Customer;
import model.Order;
import model.Product;
import payments.PaymentProcessor;
import payments.impl.CODPayment;
import payments.impl.CreditCardPayment;
import payments.impl.MomoPayment;
import payments.itf.PaymentMethod;
import repository.DatabaseOrderRepository;
import repository.FileOrderRepository;
import repository.OrderRepository;
import service.EmailService;
import service.NotificationService;
import service.OrderService;
import service.SMSNotification;

void main() {
    //Bai1
    Product p1 = new Product("SP01", "Laptop", 15000000.0);
    Product p2 = new Product("SP02", "Chuột", 300000.0);
    System.out.println("Tạo sản phẩm: SP01 - Laptop, SP02 - Chuột");

    Customer customer = new Customer("Nguyễn Văn A", "a@example.com", "HaNoi");
    System.out.println("Tạo khách hàng: " + customer.getCustomerName() + " - " + customer.getCustomerEmail());

    Order order = new Order("ORD001", customer);
    order.addProduct(p1);
    order.addProduct(p2);
    System.out.println("Đơn hàng ORD001 được tạo với 2 sản phẩm.");

    OrderCalculator calculator = new OrderCalculator();
    double total = calculator.calculateTotal(order);
    System.out.println("Tổng tiền: " + String.format("%,.0f", total));

    FileOrderRepository repository = new FileOrderRepository();
    repository.save(order);

    EmailService emailService = new EmailService();
    emailService.sendConfirmation(order);

    //Bai2
    double amount = 1000000;

    calculator.setDiscountStrategy(new PercentageDiscount(10));
    printResult("PercentageDiscount 10%", calculator.calculateFinalPrice(amount));

    calculator.setDiscountStrategy(new FixedDiscount(50000));
    printResult("FixedDiscount 50.000", calculator.calculateFinalPrice(amount));

    calculator.setDiscountStrategy(new NoDiscount());
    printResult("NoDiscount", calculator.calculateFinalPrice(amount));

    calculator.setDiscountStrategy(new HolidayDiscount());
    printResult("HolidayDiscount 15%", calculator.calculateFinalPrice(amount));

    //Bai3
    PaymentProcessor processor = new PaymentProcessor();
    PaymentMethod cod = new CODPayment();
    processor.execute(cod, 500000);

    PaymentMethod creditCard = new CreditCardPayment();
    processor.execute(creditCard, 1000000);

    PaymentMethod momo = new MomoPayment();
    processor.execute(momo, 750000);

    System.out.println("------------------------------------");
    System.out.println("KIỂM TRA LSP:");

    PaymentMethod method;

    method = new CreditCardPayment();
    processor.execute(method, 1000000);

    method = new MomoPayment();
    processor.execute(method, 1000000);

    //Bai4
    System.out.println("--- Cấu hình 1: File & Email ---");
    OrderRepository fileRepo = new FileOrderRepository();
    NotificationService email = new EmailService();

    OrderService service1 = new OrderService(fileRepo, email);
    service1.createOrder(new Order("ORD001", customer));

    System.out.println("\n--- Cấu hình 2: Database & SMS ---");
    OrderRepository dbRepo = new DatabaseOrderRepository();
    NotificationService sms = new SMSNotification();

    OrderService service2 = new OrderService(dbRepo, sms);
    service2.createOrder(new Order("ORD001", customer));
}

private static void printResult(String type, double finalPrice) {
    System.out.println("Đơn hàng: 1.000.000, áp dụng " + type);
    System.out.println("Số tiền sau giảm: " + String.format("%,.0f VNĐ", finalPrice));
    System.out.println("--------------------------------------------");
}
