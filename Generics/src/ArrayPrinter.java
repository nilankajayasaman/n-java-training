public class ArrayPrinter {

    public <E> void printArray(E[] t){
        for (E x: t) {
            System.out.println(x);
        }
        System.out.println();
    }

}
