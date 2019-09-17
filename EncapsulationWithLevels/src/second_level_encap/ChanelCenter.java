package second_level_encap;


import java.util.ArrayList;

public class ChanelCenter {

    private static ArrayList<Patient> patients;

    static {
        patients = new ArrayList<>();
    }

    public void addPatient(String name,int age,String disease){
        patients.add(new Patient(name,age,disease));
    }

    public void printPatients(){

        patients.forEach(patient -> {
            System.out.println(patient.toString());
        });

    }


    class Patient {

        private String name;
        private int age;
        private String disease;


        public Patient(String name, int age, String disease) {
            this.name = name;
            this.age = age;
            this.disease = disease;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
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
