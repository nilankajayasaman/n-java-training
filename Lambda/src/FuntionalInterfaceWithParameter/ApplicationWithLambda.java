package FuntionalInterfaceWithParameter;

public class ApplicationWithLambda {

    public static void main(String[] args) {
        Math m = x -> x*x;

        m.power(5);
        System.out.println(m.power(5));
    }

}
