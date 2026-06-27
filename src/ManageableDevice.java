public interface ManageableDevice {
    void turnOn();
    void turnOff();
    String getStatus();

    int getId();
    String getMacAddress();
    String getName();
    String getRoom();
    void accept(DeviceVisitor visitor);
}