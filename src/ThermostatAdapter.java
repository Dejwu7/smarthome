public class ThermostatAdapter implements ManageableDevice {
    private int id;
    private String name = "Thermostat";
    private String room = "Not assigned";
    private String macAddress;
    private LegacyThermostat legacyThermostat;
    private HeatingStrategy strategy;

    public ThermostatAdapter(int id, String macAddress, LegacyThermostat legacyThermostat) {
        this.id = id;
        this.macAddress = macAddress;
        this.legacyThermostat = legacyThermostat;
    }

    @Override public void turnOn() { legacyThermostat.enableHeating(); }
    @Override public void turnOff() { legacyThermostat.disableHeating(); }
    @Override public String getStatus() { return name + " -> Temp: " + legacyThermostat.fetchCurrentTemperature() + "C"; }
    @Override public int getId() { return id; }
    @Override public String getMacAddress() { return macAddress; }
    @Override public String getName() { return name; }
    @Override public String getRoom() { return room; }

    public void setStrategy(HeatingStrategy strategy) {
        this.strategy = strategy;
    }

    public void evaluateTemperature(boolean isSomeoneHome) {
        if (strategy != null) {
            double current = legacyThermostat.fetchCurrentTemperature();
            double target = strategy.calculateTargetTemperature(current, isSomeoneHome);
            System.out.println("[Termostat] Obecna temp: " + current + "C. Cel: " + target + "C.");
            if (current < target) {
                turnOn();
            } else {
                turnOff();
            }
        }
    }
}