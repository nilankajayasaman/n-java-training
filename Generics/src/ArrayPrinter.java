public class ArrayPrinter {

    public <T> void printArray(T[] t){
        for (T x: t) {
            System.out.println(x);
        }
        System.out.println();
    }

}
