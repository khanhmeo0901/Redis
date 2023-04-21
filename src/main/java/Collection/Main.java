package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> list = new HashSet<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(4);

        System.out.println(list);
    }
}
