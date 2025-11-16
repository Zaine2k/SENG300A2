import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    private CustomerStation station;
    private Session session;

    @BeforeEach
    void setup() {
        station = new CustomerStation("KIOSK-1");
        session = new Session(station);
    }

    @Test
    void newSession_startsUnblocked_andHasCorrectStation() {
        assertFalse(session.isBlocked());
        assertEquals(station, session.getStation());
    }

    @Test
    void addItem_increasesTotal() {
        Item apple = new Item("A1", "Apple", 1.25, 0.2);
        Item banana = new Item("B2", "Banana", 0.75, 0.15);

        session.addItem(apple);
        session.addItem(banana);

        assertEquals(2.0, session.calculateTotal(), 1e-9);
    }

    @Test
    void blockAndUnblock_toggleState() {
        assertFalse(session.isBlocked());
        session.blockSession();
        assertTrue(session.isBlocked());
        session.unblockSession();
        assertFalse(session.isBlocked());
    }
}
