package ioc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    // Spring: Hello, Tom!
    public static void main(String[] args) {
//        Hello hello = new Hello();
//        hello.setName("Jerry");
//        hello.sayHello();

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = (Hello) applicationContext.getBean("hello");

        hello.sayHello();
    }
}
