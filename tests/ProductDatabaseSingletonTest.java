import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductDatabaseSingletonTest {
    @Test
    void instance_isSingleton() {
        ProductDatabase a = ProductDatabase.getInstance();
        ProductDatabase b = ProductDatabase.getInstance();
        assertSame(a, b, "ProductDatabaseSingletonTest must be a singleton instance");
    }
}
