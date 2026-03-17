package cg.demo.springcoreday1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.springcoreday1.exp3.SBU;

public class App2 {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("exp3.xml");

        SBU sbu = (SBU) context.getBean("sbu");

        sbu.display();
    }
}
