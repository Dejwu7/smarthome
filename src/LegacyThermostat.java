public class LegacyThermostat {
    private boolean heating = false;

    public void enableHeating() {
        this.heating = true;
        System.out.println("[LegacyThermostat] Ogrzewanie włączone.");
    }

    public void disableHeating() {
        this.heating = false;
        System.out.println("[LegacyThermostat] Ogrzewanie wyłączone.");
    }

    public double fetchCurrentTemperature() {
        return 18.5;
    }
}