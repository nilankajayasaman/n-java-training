package lk.codelabs.encapsulation;

public class Application {

    public static void main(String[] args) {


//        BusStation busStation = new BusStation();
//        BusStation.Bus bus = busStation.new Bus("Red");

//        BusStation.Bus bus = new BusStation().new Bus("Red");
//
//        for (BusStation.Bus bus: BusStation.buses){
//
//            System.out.println(bus);
//
//        }

        BusStation busStation = new BusStation();
        busStation.addBus("Green");
        busStation.addBus(busStation.new Bus("Red"));
        busStation.addBus(new BusStation().new Bus("Blue"));

//        for (BusStation.Bus bus: busStation.getBuses()){
//
//            System.out.println(bus);
//
//        }
        busStation.getBuses();

    }

}
