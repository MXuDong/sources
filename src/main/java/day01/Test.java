package day01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * @author Dong
 * @since V1.0
 */

public class Test {

    public static void main(String[] args) {
        // 查阅源码即可
        Collection collection;

        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (Integer x = 0; x < 100; x++) {
            integers.add(x);
        }

        System.out.println(integers);
        integers.removeIf(((Predicate<Integer>) integer -> integer > 25).and((Predicate<Integer>) x -> x < 75).negate());
        System.out.println(integers);
    }
}
