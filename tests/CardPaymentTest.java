import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CardPaymentTest {
    @ParameterizedTest(name = "amount={0} should approve")
    @CsvSource({ "0.00", "1.00", "25.50", "100.00" })
    void card_payment_approves_commonAmounts(double amount) {
        PaymentProcessor pp = new PaymentProcessor();
        pp.setPaymentStrategy(new CardPayment("4111111111111111", "VISA"));
        assertTrue(pp.processPayment(amount));
    }

}