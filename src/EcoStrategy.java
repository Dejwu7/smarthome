public class EcoStrategy implements HeatingStrategy {
    @Override
    public double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome) {
        return isSomeoneHome ? 19.0 : 15.0;
    }
}