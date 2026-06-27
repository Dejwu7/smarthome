public class MovingState implements BlindState {
    @Override public void open(SmartBlind blind) { System.out.println("[Roleta] Ignoruje, jest w ruchu."); }
    @Override public void close(SmartBlind blind) { System.out.println("[Roleta] Ignoruje, jest w ruchu."); }
    @Override
    public void stop(SmartBlind blind) {
        System.out.println("[Roleta] Zatrzymano awaryjnie.");
        blind.setState(new OpenedState());
    }
}