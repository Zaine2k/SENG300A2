public class VisualAlert implements Observer {
    private boolean lastAlertVisible = false;

    @Override
    public void update(BaggingArea subject) {
        lastAlertVisible = subject.hasDiscrepancy();
    }
    public boolean isAlertVisible() { return lastAlertVisible; }
}
