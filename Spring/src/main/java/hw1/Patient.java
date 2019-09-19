package hw1;

public class Patient {
    Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    public void getTreatment(){
        System.out.println("Вам проведено лечение");
        hospital.billing();
    }
}
