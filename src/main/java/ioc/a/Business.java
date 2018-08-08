package ioc.a;

public class Business { //

//    private FloppyWriter floppyWriter;
    private UsbWriter usbWriter;

//    public Business(FloppyWriter floppyWriter) {
//        this.floppyWriter = floppyWriter;
//    }

    public Business(UsbWriter usbWriter) {
        this.usbWriter = usbWriter;
    }

//    public void saveData() {
//        this.floppyWriter.writeToFloppy(); // NPE
//    }

    public void saveData() {
        this.usbWriter.writeToUsb();
    }
}
