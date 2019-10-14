package sources.collections.c_array_list;

import java.util.ArrayList;

/**
 * @author Dong
 */

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList;
        mockGrow();
    }

    /**
     * mock the grow method in ArrayList
     */
    public static void mockGrow(){
        int x = 0;
        int y = 10;
        int countX = 0;
        int countY = 0;
        while (x != y){
            if(x > y){
                y = y + 1;
                y = y + (y >> 1);
                countY++;
            }
            if (x < y){
                x = x + 1;
                x = x + (x >> 1);
                countX++;
            }
            System.out.println("x:" + x + ";Count - x :" + countX + "; y:" + y + "; Count - y :" + countY);
        }

    }
}
