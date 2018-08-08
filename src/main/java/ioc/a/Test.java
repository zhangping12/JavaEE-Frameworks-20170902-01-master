package ioc.a;

public class Test {
    public static void main(String[] args) {
//        Business business = new Business(new FloppyWriter());
        Business business = new Business(new UsbWriter());
        business.saveData();
    }
}
