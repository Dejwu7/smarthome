public class OpenedState implements BlindState {
    @Override public void open(SmartBlind blind) { System.out.println("[Roleta] Już otwarta."); }
    @Override
    public void close(SmartBlind blind) {
        System.out.println("[Roleta] Rozpoczynam zamykanie...");
        blind.setState(new MovingState());
    }
    @Override public void stop(SmartBlind blind) { System.out.println("[Roleta] Silnik stoi."); }
}