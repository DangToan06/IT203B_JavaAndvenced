package sx2.factories;

import sx2.core.IDiscountStrategy;
import sx2.core.INotificationService;
import sx2.core.IPaymentMethod;
import sx2.core.ISalesChannelFactory;
import sx2.services.discount.POSDiscount;

public class StorePOSFactory implements ISalesChannelFactory {
    public IDiscountStrategy createDiscount() { return new POSDiscount(); }
    public IPaymentMethod createPayment() { return () -> System.out.println("Thanh toan tien mat hoac quet the tai quay"); }
    public INotificationService createNotification() { return () -> System.out.println("In hoa don giay"); }
}
