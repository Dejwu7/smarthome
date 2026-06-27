import java.util.ArrayList;
import java.util.List;

public class HomeHub {
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

    public List<ManageableDevice> getDevicesByRoom() {
        return  devices.stream().sorted().toList();
    }

}