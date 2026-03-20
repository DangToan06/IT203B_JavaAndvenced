import org.example.luyenTap1.StockServerConnection;
import org.example.luyenTap1.TradingService;
import org.example.luyenTap1.exception.TradingException;


void main(String[] args) {
    Scanner scanner =new Scanner(System.in);

    try(StockServerConnection stockServerConnection = new StockServerConnection()){
        System.out.println("Please enter stock code:");
        String stockCode = scanner.next();
        System.out.println("Please enter stock price:");
        double stockPrice = scanner.nextDouble();
        System.out.println("Please enter stock balance:");
        double balance = scanner.nextDouble();
        System.out.println("Please enter stock quantity:");
        int quantity = scanner.nextInt();

        TradingService  tradingService = new TradingService();

        tradingService.executeTrade(stockServerConnection,stockCode,quantity, stockPrice, balance);

        } catch (TradingException e) {
            // Lỗi do người dùng nhập sai -> Chỉ hiện thông báo
            System.err.println("LỖI NGHIỆP VỤ: " + e.getMessage());
        } catch (IOException e) {
            // Lỗi hệ thống -> Log lỗi và yêu cầu kiểm tra đường truyền
            System.err.println("LỖI KỸ THUẬT (Mạng/Server): " + e.getMessage());
            System.out.println("Vui lòng kiểm tra lại kết nối internet của bạn.");
        }
}