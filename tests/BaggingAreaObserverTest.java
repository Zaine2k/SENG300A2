import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Customer station test, bagging area test, visual alert test.

public class BaggingAreaObserverTest {

    @Test
    void sessionBlocks_whenScaleIsMismatched() {
        CustomerStation station = new CustomerStation("KIOSK-1");
        Session session = station.getSession();
        BaggingArea bag = station.getBaggingArea();

        // observer that blocks the session on
        SessionBlocker blocker = new SessionBlocker(session);
        bag.attach(blocker);

        // Add a random item
        Item milk = new Item("SKU1", "Milk 1L", 3.99, 1.0);
        bag.addItem(milk);

        // Force a mismatch on the scale
        bag.getScale().setWeightForTest(0.2);

        // SessionBlocker should set blocked = true - should notify
        bag.notifyObservers();

        assertTrue(session.isBlocked(), "Session should be blocked when scale =! expected");
    }

    @Test
    void visualAlertReflectsDiscrepancyState() {
        CustomerStation station = new CustomerStation("KIOSK-2");
        BaggingArea bag = station.getBaggingArea();

        VisualAlert alert = new VisualAlert();
        bag.attach(alert);

        // Start matched
        bag.getScale().setWeightForTest(0.0);
        bag.notifyObservers();
        assertFalse(alert.isAlertVisible(), "No discrepancy → alert off");

        // Create mismatch
        Item chips = new Item("SKU2", "Chips", 2.49, 0.3);
        bag.addItem(chips);
        bag.getScale().setWeightForTest(0.0);  // this is the wrong actual weight
        bag.notifyObservers();

        assertTrue(alert.isAlertVisible(), "Mismatch → alert should be visible");
    }
}
