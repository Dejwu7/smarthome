import java.util.ArrayList;
import java.util.List;

public class MotionSensor {
    private String id;
    private List<SensorObserver> observers = new ArrayList<>();

    public MotionSensor(String id) {
        this.id = id;
    }

    public void attach(SensorObserver observer) { observers.add(observer); }
    public void detach(SensorObserver observer) { observers.remove(observer); }

    public void detectMotion() {
        System.out.println("[Czujnik] Wykryto ruch w sektorze " + id + "!");
        for (SensorObserver obs : observers) {
            obs.onSensorTriggered(id, "Wykryto obecność domownika.");
        }
    }
}