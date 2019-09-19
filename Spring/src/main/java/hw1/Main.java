package hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Patient patient = context.getBean("patient", Patient.class);
        patient.getTreatment();
    }
}
