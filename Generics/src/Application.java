public class Application {

    public static void main(String[] args) {

        Car car = new Car();
        Bus bus = new Bus();


        Vehicle<Car> carVehicle = new Vehicle<>(car);
        Vehicle<Bus> busVehicle = new Vehicle<>(bus);

        carVehicle.drive();
        busVehicle.drive();


        ArrayPrinter arrayPrinter = new ArrayPrinter();

        Integer[] integers = {1,2,3,4,5,6};
        String[] strings = {"a","b","c","d","e"};

        arrayPrinter.printArray(integers);
        arrayPrinter.printArray(strings);

    }


}
