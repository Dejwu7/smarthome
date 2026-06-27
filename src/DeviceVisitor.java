public interface DeviceVisitor {
    void visit(SmartDevice device);
    void visit(ThermostatAdapter adapter);
    void visit(SmartBlind blind);
}