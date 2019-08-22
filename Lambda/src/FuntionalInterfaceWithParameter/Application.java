package FuntionalInterfaceWithParameter;

public class Application {

    public static void main(String[] args) {

        Math m = new Math() {
            @Override
            public int power(int x) {
                return x*x;
            }
        };

        System.out.println(m.power(5));

    }

}
