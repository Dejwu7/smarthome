void main() {
    try {
        SmartDevice washingMachine = new SmartDevice.Builder(1, "Pralka").withMacAddress("12:34:56:78:99:19:90:17:908").build();
        HomeHub.getInstance().registerDevice(washingMachine);
        HomeHub.getInstance().registerDevice(new SmartDevice.Builder(2, "Kuchnia").withMacAddress("12:34:56:78:99:19:90:17:906").build());
        System.out.println(HomeHub.getInstance().getDevicesByRoom());
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}
