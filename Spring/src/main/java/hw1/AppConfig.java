package hw1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="hospital")
    public Hospital Hospital() {
        return new HospitalFree() ;
    }

    @Bean(name="patient")
    public Patient patient (Hospital hospital){
        Patient patient = new Patient();
        patient.setHospital(hospital);
        return patient;
    }
}

