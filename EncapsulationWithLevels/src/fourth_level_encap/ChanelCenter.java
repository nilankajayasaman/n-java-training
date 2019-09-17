package fourth_level_encap;


import java.util.ArrayList;
import java.util.List;

public class ChanelCenter {


    private  ArrayList<Patient> patients;

    {
        patients = new ArrayList<>();
    }

    public ChanelCenter() {

    }

    public void addPatients(Patient patient){
        patients.add(patient);
    }

    public void addPatients(String name,int age,ArrayList<String> symptoms){
        patients.add(new Patient(name,age,symptoms));

    }

    public void printPatients(){

        patients.forEach(patient -> {
            checkDisease(patient);
            System.out.println(patient.toString());
        });

    }

    public void checkDisease(Patient patient){
        new Object(){
            public void checkDisease(Patient patient){
                if (patient.getSymptoms().contains("Headache") && patient.getSymptoms().contains("Pain")){
                    System.out.println("Fever");
                    patient.setDisease("Fever");
                }else if (patient.getSymptoms().contains("postnasal drip") || patient.getSymptoms().contains("Hoarseness")){
                    System.out.println("Cough");
                    patient.setDisease("Cough");
                }else {
                    System.out.println("unknown");
                    patient.setDisease("Unknown");
                }
            }
        }.checkDisease(patient);
    }
    public class Patient {

        private String name;
        private int age;
        private String disease;
        private List<String> symptoms;


        public Patient(String name, int age, List<String> symptoms) {
            this.name = name;
            this.age = age;
            this.symptoms = symptoms;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public void addSymptoms(String symptom){
            if (symptoms != null){
                symptoms.add(symptom);
            }else {
                symptoms = new ArrayList<>();
                symptoms.add(symptom);
            }
        }

        public List<String> getSymptoms() {
            return symptoms;
        }


        @Override
        public String toString() {
            return "Patient{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", disease='" + disease + '\'' +
                    '}';
        }
    }

}
