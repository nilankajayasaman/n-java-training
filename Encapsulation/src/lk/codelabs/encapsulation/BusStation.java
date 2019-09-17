package lk.codelabs.encapsulation;

import java.util.ArrayList;

public class BusStation {

//    public static ArrayList<Bus> buses;// = new ArrayList<>();
    private ArrayList<Bus> buses;// = new ArrayList<>();

//    static{
//
//        buses = new ArrayList<>();
//        buses.add(new BusStation().new Bus("Red"));
//        buses.add(new BusStation().new Bus("Green"));
//        buses.add(new BusStation().new Bus("White"));
//        buses.add(new BusStation().new Bus("Blue"));
//        buses.add(new BusStation().new Bus("Pink"));
//    }

    {
        buses = new ArrayList<>();

    }

    public BusStation() {
    }

    public BusStation(String color) {
        buses.add(new Bus(color));
    }

    public void addBus(String color){
        buses.add(new Bus(color));
    }

    public void addBus(Bus bus){
        buses.add(bus);
    }

//    public ArrayList<Bus> getBuses() {
//        return buses;
//    }

    public void getBuses() {
        for (Bus bus:buses) {
            validate(bus.color);
            System.out.println(bus.getColor());
        }
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }


    public void validate(String color){
//        class BusValidator{
//            public void colorValidate(){
//                if ("Red".equalsIgnoreCase(color)){
//                    System.out.println("valid");
//                }else {
//                    System.out.println("invalid");
//                }
//
//            }
//        }
//
//        new BusValidator().colorValidate();

        new Object(){
            public void colorValidate(){
                if ("Red".equalsIgnoreCase(color)){
                    System.out.println("valid");
                }else {
                    System.out.println("invalid");
                }

            }
        }.colorValidate();


    }

    class Bus {

        private String color;

        public Bus(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }





        @Override
        public String toString() {
            return "Bus{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }
}
