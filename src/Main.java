void main() {
    try {
        SmartDevice washingMachine = new SmartDevice.Builder(1, "Pralka").withMacAddress("123456789").build();
    } catch (Exception e) {
        System.err.println(e.getMessage());
    };
}
