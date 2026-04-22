public class SmartDevice {
    private int id;
    private String name;
    private String room;
    private String macAddress;
    private double firmwareVersion;

    private SmartDevice(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.room = builder.room;
        this.macAddress = builder.macAddress;
        this.firmwareVersion = builder.firmwareVersion;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getFirmwareVersion() {
        return firmwareVersion;
    }


    public static class Builder {
        private int id;
        private String name;
        private String room = "Not assigned";
        private String macAddress = "Not defined";
        private double firmwareVersion = 0.0;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder withMacAddress(String macAddress) throws InvalidMacAddressException{
            if (macAddress.length() < 17 && !macAddress.contains(":")) {
                throw new InvalidMacAddressException("Invalid MAC address format");
            } else {
                this.macAddress = macAddress;
                return this;
            }
        }

        public Builder withFirmwareVersion(double firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        public SmartDevice build() {
            return new SmartDevice(this);
        }
    }
}
