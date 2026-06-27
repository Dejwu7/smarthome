import java.time.LocalDateTime;

public class EnergyMonitoringDecorator extends DeviceDecorator {

    public EnergyMonitoringDecorator(ManageableDevice decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("[MONITORING] Urządzenie " + getName() + " pobiera prąd od: " + LocalDateTime.now());
    }
}