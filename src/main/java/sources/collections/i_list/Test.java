package sources.collections.i_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dong
 */

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list);

        //排序：奇数在前 偶数在后 小数在前
        list.sort(((Comparator<Integer>) (o1, o2) -> {
            if (o1 % 2 == o2 % 2) {
                return 0;
            }
            return o1 % 2 == 0 ? 1 : -1;
        }).thenComparingInt(o -> o));

        System.out.println(list);
    }
}
