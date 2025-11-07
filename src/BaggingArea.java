import java.util.ArrayList;
import java.util.List;

public class BaggingArea implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private final Scale scale = new Scale();
    private double expectedWeight = 0.0;
    private double tolerance = 0.05; // 5% tolerance

    public void addItem(Item item) {
        items.add(item);
        expectedWeight += item.getExpectedWeight();
        notifyObservers();
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            expectedWeight -= item.getExpectedWeight();
            notifyObservers();
        }
    }

    public boolean hasDiscrepancy() {
        double actual = scale.measureWeight();
        if (expectedWeight == 0) return Math.abs(actual) > 1e-6;
        double diffRatio = Math.abs(actual - expectedWeight) / expectedWeight;
        return diffRatio > tolerance;
    }

    public double getExpectedWeight() { return expectedWeight; }
    public double getActualWeight() { return scale.measureWeight(); }
    public Scale getScale() { return scale; }

    @Override public void attach(Observer o) { observers.add(o); }
    @Override public void detach(Observer o) { observers.remove(o); }
    @Override public void notifyObservers() { for (Observer o : observers) o.update(this); }
}
