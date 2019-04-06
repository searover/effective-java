package net.mindview.holding;

import java.util.Arrays;
import java.util.List;

/**
 * @author searover
 */
public class AddGroups {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.set(0, 11);
//        list.add(6); Cause UnsupportedOperationException
    }
}
