public class AttendantDisplay implements Observer {
    private String lastAlert = "";
    private boolean alertVisible = false;

    @Override
    public void update(BaggingArea subject) {
        if (subject.hasDiscrepancy()) {
            double diff = subject.getActualWeight() - subject.getExpectedWeight();
            displayAlert(diff);
        } else {
            alertVisible = false;
            lastAlert = "";
        }
    }

    public void displayAlert(double discrepancy) {
        this.lastAlert = "Discrepancy detected: " + discrepancy;
        this.alertVisible = true;
    }

    public boolean isAlertVisible() {
        return alertVisible;
    }

    public String getLastAlert() {
        return lastAlert;
    }
}
