import first_level_encap.ChanelCenter;

import java.util.ArrayList;

public class Application {


    public static void main(String[] args) {
        System.out.println("First Level Encapsulation");
        System.out.println("--------------------------");
        firstLevelEncapsulation();
        System.out.println("--------------------------");

        System.out.println("Second Level Encapsulation");
        secondLevelEncapsulation();
        System.out.println("--------------------------");

        System.out.println("Third Level Encapsulation");
        thirdLevelEncapsulation();
        System.out.println("--------------------------");

        System.out.println("Fourth Level Encapsulation");
        fourthLevelEncapsulation();
        System.out.println("--------------------------");

    }


    public static void firstLevelEncapsulation(){
        ChanelCenter.addPatient("Kumara",29,"fever");
        ChanelCenter.addPatient("Saman",25,"fever");
        ChanelCenter.addPatient("Supun",22,"fever");
        ChanelCenter.printPatients();
    }

    public static void secondLevelEncapsulation(){

        second_level_encap.ChanelCenter chanelCenter = new second_level_encap.ChanelCenter();


        chanelCenter.addPatient("Kumara",29,"fever");
        chanelCenter.addPatient("Saman",25,"fever");
        chanelCenter.addPatient("Supun",22,"fever");
        chanelCenter.printPatients();

    }

    public static void thirdLevelEncapsulation(){

        third_level_encap.ChanelCenter chanelCenter = new third_level_encap.ChanelCenter();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Pain");
        arrayList.add("Headache");
        third_level_encap.ChanelCenter.Patient patient1 = chanelCenter.new Patient("Kumara",25,arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("postnasal drip");
        arrayList.add("Hoarseness");
        third_level_encap.ChanelCenter.Patient patient2 = chanelCenter.new Patient("Saman",22,arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("Stomach ache");
        arrayList.add("chest pain");
        third_level_encap.ChanelCenter.Patient patient3 = chanelCenter.new Patient("Supun",20,arrayList);

        chanelCenter.addPatients(patient1);
        chanelCenter.addPatients(patient2);
        chanelCenter.addPatients(patient3);

        chanelCenter.printPatients();

    }

    public static void fourthLevelEncapsulation(){
        fourth_level_encap.ChanelCenter chanelCenter = new fourth_level_encap.ChanelCenter();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Pain");
        arrayList.add("Headache");
        fourth_level_encap.ChanelCenter.Patient patient1 = chanelCenter.new Patient("Wasantha",30,arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("postnasal drip");
        arrayList.add("Hoarseness");
        fourth_level_encap.ChanelCenter.Patient patient2 = chanelCenter.new Patient("Sunil",35,arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("Stomach ache");
        arrayList.add("chest pain");
        fourth_level_encap.ChanelCenter.Patient patient3 = chanelCenter.new Patient("Supun",20,arrayList);

        chanelCenter.addPatients(patient1);
        chanelCenter.addPatients(patient2);
        chanelCenter.addPatients(patient3);

        chanelCenter.printPatients();


    }

}
