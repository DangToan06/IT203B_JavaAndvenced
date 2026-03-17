package sx2.core;

public interface ISalesChannelFactory {
    IDiscountStrategy createDiscount();
    IPaymentMethod createPayment();
    INotificationService createNotification();
}
