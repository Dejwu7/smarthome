public class DeviceFactory {
    public static SmartDevice createLivingRoomBulb(int id, String name)throws InvalidMacAddressException {
        return new SmartDevice.Builder(id, name).withRoom("Living Room").withMacAddress("00:1A:2B:3C:4D:6E").withFirmwareVersion(2.0).build();
    }

    public static SmartDevice createBasicThermostat(int id) throws InvalidMacAddressException{
        return new SmartDevice.Builder(id, "Thermostat").withMacAddress("00:1A:2B:3C:4D:5F").withFirmwareVersion(1.0).build();
    }

}
