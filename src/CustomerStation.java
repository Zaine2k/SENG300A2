public class CustomerStation extends Station {
    private final BaggingArea baggingArea;
    private final Session session;
    private final PaymentProcessor paymentProcessor;

    public CustomerStation(String id) {
        super(id);
        this.baggingArea = new BaggingArea();
        this.session = new Session(this);
        this.paymentProcessor = new PaymentProcessor();
    }
    public BaggingArea getBaggingArea() { return baggingArea; }
    public Session getSession() { return session; }
    public PaymentProcessor getPaymentProcessor() { return paymentProcessor; }

    public void scanItem(Item item) {
        session.addItem(item);
        baggingArea.addItem(item);
    }
}
