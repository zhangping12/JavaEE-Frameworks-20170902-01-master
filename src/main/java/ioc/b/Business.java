package ioc.b;

public class Business {
    private DeviceWriter deviceWriter;

    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public void saveData() {
        this.deviceWriter.saveToDevice();
    }
}
