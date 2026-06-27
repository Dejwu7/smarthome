import java.util.ArrayList;
import java.util.List;

public class HomeHub implements SensorObserver {
    private final List<ManageableDevice> devices = new ArrayList<>();
    private static final HomeHub instance = new HomeHub();

    private HomeHub() { }

    public static HomeHub getInstance() {
        return instance;
    }

    public List<ManageableDevice> getDevices() {
        return devices;
    }

    public void registerDevice(SmartDevice device) throws DuplicateDeviceException {
        for (ManageableDevice smartDevice : devices) {
            if (smartDevice.getId() == device.getId() || smartDevice.getMacAddress().equals(device.getMacAddress())) {
                throw new DuplicateDeviceException("Istnieje już takie urządzenie");
            }
        }
        devices.add(device);
    }

    @Override
    public void onSensorTriggered(String sensorId, String eventDetails) {
        System.out.println("ALARM: Wykryto zdarzenie z czujnika [" + sensorId + "] - " + eventDetails);
    }

    public List<ManageableDevice> getDevicesByRoom() {
        return  devices.stream().sorted().toList();
    }

    public void runDiagnostics() {
        System.out.println("\n=== RAPORT SPRZĘTOWY ===");
        DiagnosticsVisitor visitor = new DiagnosticsVisitor();
        for (ManageableDevice device : devices) {
            device.accept(visitor);
        }
        System.out.println(visitor.getReport());
    }

}