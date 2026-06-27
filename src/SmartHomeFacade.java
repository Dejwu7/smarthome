public class SmartHomeFacade {
    private HomeHub homeHub;

    public SmartHomeFacade(HomeHub homeHub) {
        this.homeHub = homeHub;
    }

    public void goodNightRoutine() {
        System.out.println("--- PROCEDURA: DOBRANOC ---");
        for (ManageableDevice d : homeHub.getDevices()) {
            d.turnOff();
        }
    }

    public void movieMode() {
        System.out.println("--- PROCEDURA: TRYB KINOWY ---");
        for (ManageableDevice d : homeHub.getDevices()) {
            if (d.getName().toLowerCase().contains("tv") || d.getName().toLowerCase().contains("telewizor")) {
                d.turnOn();
            } else if (d.getName().toLowerCase().contains("bulb") || d.getName().toLowerCase().contains("żarówka")) {
                d.turnOff();
            }
        }
    }
}