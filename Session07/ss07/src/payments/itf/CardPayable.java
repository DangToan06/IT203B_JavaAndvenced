package payments.itf;

public interface CardPayable extends PaymentMethod {
    void validateCard();
}