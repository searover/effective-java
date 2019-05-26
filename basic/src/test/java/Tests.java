import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tests {
    @Test
    public void name() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        Collection<String> values = map.values();
        System.out.println(values);
    }
}
