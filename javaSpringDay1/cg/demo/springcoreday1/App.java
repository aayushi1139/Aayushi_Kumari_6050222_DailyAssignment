package cg.demo.springcoreday1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.springcoreday1.exp1.Employee;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("exp1.xml");

        Employee emp = (Employee) context.getBean("emp");

        emp.display();
    }
}