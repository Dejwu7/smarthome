public class SmartBlind implements ManageableDevice {
    private int id;
    private BlindState currentState;

    public SmartBlind(int id) {
        this.id = id;
        this.currentState = new ClosedState();
    }

    public void setState(BlindState state) { this.currentState = state; }

    public void openBlind() { currentState.open(this); }
    public void closeBlind() { currentState.close(this); }
    public void stopBlind() { currentState.stop(this); }

    @Override public void turnOn() { openBlind(); }
    @Override public void turnOff() { closeBlind(); }
    @Override public String getStatus() { return "SmartBlind - Stan: " + currentState.getClass().getSimpleName(); }

    @Override public int getId() { return id; }
    @Override public String getMacAddress() { return "00:00:00:00:00:00"; }
    @Override public String getName() { return "Rolety Antywłamaniowe"; }
    @Override public String getRoom() { return "Cały dom"; }
}