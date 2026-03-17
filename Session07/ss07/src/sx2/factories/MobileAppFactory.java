package sx2.factories;

import sx2.core.IDiscountStrategy;
import sx2.core.INotificationService;
import sx2.core.IPaymentMethod;
import sx2.core.ISalesChannelFactory;
import sx2.services.discount.MobileDiscount;

public class MobileAppFactory implements ISalesChannelFactory {
    public IDiscountStrategy createDiscount() { return new MobileDiscount(); }
    public IPaymentMethod createPayment() { return () -> System.out.println("Thanh toan qua vi MoMo"); }
    public INotificationService createNotification() { return () -> System.out.println("Gui Push Notification"); }
}