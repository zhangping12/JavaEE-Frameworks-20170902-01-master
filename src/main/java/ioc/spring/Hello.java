package ioc.spring;

public class Hello {
    private String name;

//    public Hello(String name) {
//        this.name = name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, " + this.name + "!");
    }
}
