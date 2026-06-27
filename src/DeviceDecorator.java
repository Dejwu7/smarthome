public abstract class DeviceDecorator implements ManageableDevice {
    protected ManageableDevice decoratedDevice;

    public DeviceDecorator(ManageableDevice decoratedDevice) {
        this.decoratedDevice = decoratedDevice;
    }

    @Override public void turnOn() { decoratedDevice.turnOn(); }
    @Override public void turnOff() { decoratedDevice.turnOff(); }
    @Override public String getStatus() { return decoratedDevice.getStatus(); }
    @Override public int getId() { return decoratedDevice.getId(); }
    @Override public String getMacAddress() { return decoratedDevice.getMacAddress(); }
    @Override public String getName() { return decoratedDevice.getName(); }
    @Override public String getRoom() { return decoratedDevice.getRoom(); }
}