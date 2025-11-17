import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AttendantDisplayTest {

    @Test
    void update_withDiscrepancy_showsAlert() {
        BaggingArea bag = new BaggingArea();
        AttendantDisplay display = new AttendantDisplay();
        bag.attach(display);

        // expected weight
        Item item = new Item("SKU1", "Milk", 3.99, 1.0);
        bag.addItem(item);

        // different actual weight
        bag.getScale().setWeightForTest(0.5);

        // trigger notify
        bag.notifyObservers();

        assertTrue(display.isAlertVisible());
        assertEquals("Discrepancy detected: -0.5", display.getLastAlert());
    }

    @Test
    void update_noDiscrepancy_clearsAlert() {
        BaggingArea bag = new BaggingArea();
        AttendantDisplay display = new AttendantDisplay();
        bag.attach(display);

        // expected 2.0, actual also 2.0
        Item item = new Item("SKU2", "Flour", 4.50, 2.0);
        bag.addItem(item);

        // pretend an alert was active
        display.displayAlert(1.0);

        bag.getScale().setWeightForTest(2.0);
        bag.notifyObservers();

        assertFalse(display.isAlertVisible());
        assertEquals("", display.getLastAlert());
    }

    @Test
    void displayAlert_setsAlertAndMessage() {
        AttendantDisplay display = new AttendantDisplay();
        display.displayAlert(3.25);

        assertTrue(display.isAlertVisible());
        assertEquals("Discrepancy detected: 3.25", display.getLastAlert());
    }
}
