import org.junit.Test;

import java.util.HashSet;

public class Tests {
    @Test
    public void name() {
        HashSet<Character> set = new HashSet<>();
        set.add('c');
        set.add('b');
        set.add('a');
        set.add('d');
        set.add('e');
        System.out.println(set);
    }
}
