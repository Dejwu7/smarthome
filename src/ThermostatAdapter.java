public class ThermostatAdapter implements ManageableDevice {
    private int id;
    private String name = "Thermostat";
    private String room = "Not assigned";
    private String macAddress;
    private LegacyThermostat legacyThermostat;

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
}