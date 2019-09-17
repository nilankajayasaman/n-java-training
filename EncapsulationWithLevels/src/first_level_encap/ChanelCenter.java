package first_level_encap;

import java.util.ArrayList;

public class ChanelCenter {

    private static ArrayList<Patient> patients;

    static {
        patients = new ArrayList<>();
    }

    public static void addPatient(String name,int age,String disease){
        patients.add(new Patient(name,age,disease));
    }

    public static void printPatients(){

        patients.forEach(patient -> {
            System.out.println(patient.toString());
        });

    }

}
