public class Scale {
    private double currentWeight;
    public double measureWeight() { return currentWeight; }
    public void setWeightForTest(double w) { this.currentWeight = w; } // test seam
    public void resetWeight() { this.currentWeight = 0.0; }
}
