public class DiagnosticsVisitor implements DeviceVisitor {
    private StringBuilder report = new StringBuilder();

    @Override
    public void visit(SmartDevice device) {
        report.append("[Standard] ").append(device.getName())
                .append(" (MAC: ").append(device.getMacAddress()).append(")\n");
    }

    @Override
    public void visit(ThermostatAdapter adapter) {
        report.append("[Adapter] ").append(adapter.getName())
                .append(" | ").append(adapter.getStatus()).append("\n");
    }

    @Override
    public void visit(SmartBlind blind) {
        report.append("[Silnik] ").append(blind.getName())
                .append(" | Logika: ").append(blind.getStatus()).append("\n");
    }

    public String getReport() {
        return report.toString();
    }
}