package ioc.c;

public class FloppyWriter implements DeviceWriter {
    @Override
    public void saveToDevice() {
        // ...
        System.out.println("save data to Floppy...");
    }
}
