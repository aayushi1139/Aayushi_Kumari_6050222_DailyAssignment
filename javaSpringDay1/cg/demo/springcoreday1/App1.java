package cg.demo.springcoreday1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cg.demo.springcoreday1.exp2.Employee;
public class App1 {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("exp2.xml");

        Employee emp = (Employee) context.getBean("emp1");

        System.out.println("Employee details");
        System.out.println(emp);

        System.out.println("sbu details=" + emp.getSbuDetails());
    }
}