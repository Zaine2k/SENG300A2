import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AudioAlertTest {

    @Test
    void update_withDiscrepancy_playsSound() {
        BaggingArea bag = new BaggingArea();
        AudioAlert audio = new AudioAlert();
        bag.attach(audio);

        // fake expected weight
        Item item = new Item("SKU1", "Milk", 4.00, 1.0);
        bag.addItem(item); // expectedWeight = 1.0

        // actual weight (very different)
        bag.getScale().setWeightForTest(0.0);
        bag.notifyObservers();                // triggers audio.update(bag)

        assertTrue(audio.didPlaySound(), "Sound should be played when there is a discrepancy");
        assertEquals("Weight discrepancy detected", audio.getLastMessage());
    }

    @Test
    void update_withoutDiscrepancy_clearsAlert() {
        BaggingArea bag = new BaggingArea();
        AudioAlert audio = new AudioAlert();
        bag.attach(audio);

        // Set expected & actual equal
        Item item = new Item("SKU2", "Chips", 2.49, 0.3);
        bag.addItem(item);
        bag.getScale().setWeightForTest(0.3);
        audio.playAlert("Previous message");   // pretend there was already an alert

        bag.notifyObservers();

        assertFalse(audio.didPlaySound(), "Sound flag should be false when no discrepancy");
        assertEquals("", audio.getLastMessage(), "Message should be cleared when no discrepancy");
    }

    @Test
    void playAlert_setsMessageAndFlag() {
        AudioAlert audio = new AudioAlert();

        audio.playAlert("Test alert");

        assertTrue(audio.didPlaySound());
        assertEquals("Test alert", audio.getLastMessage());
    }
}
