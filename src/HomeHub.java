import java.util.ArrayList;
import java.util.List;

public class HomeHub {
    List<Object> devices = new ArrayList<>();
    private static final HomeHub instance = new HomeHub();

    private HomeHub() {
    }

    public static HomeHub getInstance() {
        return instance;
    }

    public List<Object> getDevices() {
        return devices;
    }
}
