import java.util.ArrayList;
import java.util.List;

public class Session {
    private final String sessionID = "S-" + System.nanoTime();
    private final CustomerStation station;
    private final List<Item> items = new ArrayList<>();
    private boolean blocked;

    public Session(CustomerStation station) {
        this.station = station;
        this.blocked = false;
    }
    public void addItem(Item item) { items.add(item); }
    public double calculateTotal() { return items.stream().mapToDouble(Item::getPrice).sum(); }
    public void blockSession() { blocked = true; }
    public void unblockSession() { blocked = false; }
    public boolean isBlocked() { return blocked; }
    public CustomerStation getStation() { return station; }
}
