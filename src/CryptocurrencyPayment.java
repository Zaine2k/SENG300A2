public class CryptocurrencyPayment implements PaymentStrategy {
    private final String walletAddress;
    private final String cryptoType;

    public CryptocurrencyPayment(String walletAddress, String cryptoType) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public boolean processPayment(double amount) {
        return amount > 0 && walletAddress != null && walletAddress.length() >= 6 && cryptoType != null;
    }
}
