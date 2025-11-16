import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void constructorAndGetters_workNormally() {
        Item item = new Item("123", "Apple", 1.25, 0.2);

        assertEquals("123", item.getItemID());
        assertEquals("Apple", item.getItemName());
        assertEquals(1.25, item.getPrice());
        assertEquals(0.2, item.getExpectedWeight());
    }

    @Test
    void allowsNullAndNegativeValues_currentBehavior() {
        Item item = new Item(null, null, -5.0, -1.0);

        assertNull(item.getItemID());
        assertNull(item.getItemName());
        assertEquals(-5.0, item.getPrice());
        assertEquals(-1.0, item.getExpectedWeight());
    }
}
