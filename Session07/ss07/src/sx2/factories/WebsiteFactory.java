package sx2.factories;

import sx2.core.IDiscountStrategy;
import sx2.core.INotificationService;
import sx2.core.IPaymentMethod;
import sx2.core.ISalesChannelFactory;
import sx2.services.discount.WebsiteDiscount;

public class WebsiteFactory implements ISalesChannelFactory {
    public IDiscountStrategy createDiscount() { return new WebsiteDiscount(); }
    public IPaymentMethod createPayment() { return () -> System.out.println("Thanh toan qua cong Online"); }
    public INotificationService createNotification() { return () -> System.out.println("Gui email xac nhan"); }
}