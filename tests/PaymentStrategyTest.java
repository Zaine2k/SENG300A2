import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Crypto tests, cash tests, card tests

class PaymentStrategyTest {
    @Test
    void cardPayment_approved() {
        PaymentProcessor pp = new PaymentProcessor();
        pp.setPaymentStrategy(new CardPayment("4111111111111111", "VISA"));

        boolean approved = pp.processPayment(25.00);

        assertTrue(approved, "Expected card payment to approve a normal amount");
    }

    @Test
    void cashPayment_insufficient_then_sufficient() {
        PaymentProcessor pp = new PaymentProcessor();

        // Not enough cash for the amount
        pp.setPaymentStrategy(new CashPayment(5.00));
        assertFalse(pp.processPayment(10.00), "Insufficient cash should fail");

        // Enough cash works
        pp.setPaymentStrategy(new CashPayment(20.00));
        assertTrue(pp.processPayment(10.00), "Sufficient cash should pass");
    }

    @Test
    void cryptoPayment_invalidWallet_fails() {
        PaymentProcessor pp = new PaymentProcessor();
        pp.setPaymentStrategy(new CryptocurrencyPayment("bad_wallet_id", "BTC"));

        boolean approved = pp.processPayment(20.00);

        assertFalse(approved, "Invalid wallet should fail auth");
    }

    @ParameterizedTest
    @CsvSource({ "0.00, false", "1.00, true", "25.50, true", "100.00, true" })
    void card_payment_amounts(double amount, boolean expected) {
        PaymentProcessor pp = new PaymentProcessor();
        pp.setPaymentStrategy(new CardPayment("4111111111111111", "VISA"));
        assertEquals(expected, pp.processPayment(amount));
    }

}