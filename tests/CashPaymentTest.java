import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CashPaymentTest {
    @ParameterizedTest(name = "cash={0}, amount={1} -> approved={2}")
    @CsvSource({
            "10.00,  9.99,  true",
            "10.00, 10.00,  true",
            "10.00, 10.01,  false",
            " 0.00,  0.00,  true",
            " 5.00,  0.01,  true"
    })
    void cash_payment_various(double cash, double amount, boolean expectedApproved) {
        PaymentProcessor pp = new PaymentProcessor();
        pp.setPaymentStrategy(new CashPayment(cash));
        boolean approved = pp.processPayment(amount);
        assertEquals(expectedApproved, approved);
    }

}