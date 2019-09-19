package hw1;

import org.springframework.stereotype.Component;

@Component("hospital")
public class HospitalFree implements Hospital {

    public void billing() {
        System.out.println("лечение бесплатно");
    }
}
