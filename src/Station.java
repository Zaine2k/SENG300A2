public abstract class Station {
    private final String stationID;
    private boolean active;

    protected Station(String stationID) {
        this.stationID = stationID;
        this.active = true;
    }
    public String getStationID() { return stationID; }
    public boolean isActive() { return active; }
    public void activate() { this.active = true; }
    public void deactivate() { this.active = false; }
}
