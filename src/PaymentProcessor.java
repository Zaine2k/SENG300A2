public class PaymentProcessor {
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy s) { this.strategy = s; }

    public boolean processPayment(double amount) {
        if (strategy == null) throw new IllegalStateException("PaymentStrategy not set");
        return strategy.processPayment(amount);
    }
}
