public class CashPayment implements PaymentStrategy {
    private final double cashReceived;
    public CashPayment(double cashReceived) { this.cashReceived = cashReceived; }
    @Override public boolean processPayment(double amount) { return cashReceived >= amount; }
}
