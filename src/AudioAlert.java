public class AudioAlert implements Observer {
    private String lastMessage = "";
    private boolean soundPlayed = false;

    @Override
    public void update(BaggingArea subject) {
        if (subject.hasDiscrepancy()) {
            playAlert("Weight discrepancy detected");
        } else {
            soundPlayed = false;
            lastMessage = "";
        }
    }

    public void playAlert(String message) {
        this.lastMessage = message;
        this.soundPlayed = true;
    }

    public boolean didPlaySound() {
        return soundPlayed;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
