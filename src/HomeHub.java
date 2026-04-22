import java.util.ArrayList;
import java.util.List;

public class HomeHub {
    public List<SmartDevice> devices = new ArrayList<>();
    private static final HomeHub instance = new HomeHub();

    private HomeHub() { }

    public static HomeHub getInstance() {
        return instance;
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }

    public void registerDevice(SmartDevice device) throws DuplicateDeviceException {
        for (SmartDevice smartDevice : devices) {
            if (smartDevice.getId() == device.getId() || smartDevice.getMacAddress().equals(device.getMacAddress())) {
                throw new DuplicateDeviceException("Istnieje już takie urządzenie");
            }
        }
        devices.add(device);
    }

    public List<SmartDevice> getDevicesByRoom() {
        return  devices.stream().sorted().toList();
    }
}