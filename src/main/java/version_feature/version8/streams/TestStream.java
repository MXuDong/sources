package version_feature.version8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dong
 */

public class TestStream {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(7);
        integers.add(9);
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers.add(8);
        integers.add(10);

        Stream<Integer> integerStream = integers.stream();
        //输出大于3小于8并且为偶数的数字
        integerStream.filter(x -> x > 3 && x < 8).filter(x->x % 2 == 0).forEach(System.out::println);
    }
}
