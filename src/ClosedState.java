public class ClosedState implements BlindState {
    @Override
    public void open(SmartBlind blind) {
        System.out.println("[Roleta] Rozpoczynam otwieranie...");
        blind.setState(new MovingState());
    }
    @Override public void close(SmartBlind blind) { System.out.println("[Roleta] Już zamknięta."); }
    @Override public void stop(SmartBlind blind) { System.out.println("[Roleta] Silnik stoi."); }
}