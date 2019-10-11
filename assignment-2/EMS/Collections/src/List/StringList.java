package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringList {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("bcxfd");
        list.add("Bcxfd");
        list.add("bzxfd");
        list.add("zzxfd");
        list.add("Azxfd");
        list.add("azxfd");
        list.add("czxfd");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

    }


}
