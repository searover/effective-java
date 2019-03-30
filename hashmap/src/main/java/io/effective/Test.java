package io.effective;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        int length = 5000;
        stopwatch.start();
        process(new HashMap<>(), length);
        System.out.println("Process HashMap cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        stopwatch.reset().start();
        process(new MiniHashMap<>(), length);
        System.out.println("Process MiniMap cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    private static void process(MiniMap<String, String> map, int length) {
        for (int i = 0; i < length; i++) {
            map.put("key-" + i, "value-" + i);
        }
    }

    private static void process(Map<String, String> map, int length) {
        for (int i = 0; i < length; i++) {
            map.put("key-" + i, "value-" + i);
        }
    }
}
