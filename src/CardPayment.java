public class CardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String cardType;

    public CardPayment(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    @Override
    public boolean processPayment(double amount) {
        return amount > 0 && cardNumber != null && cardNumber.length() >= 12 && cardType != null;
    }
}
