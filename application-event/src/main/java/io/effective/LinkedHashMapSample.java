package io.effective;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3;
            }
        };
        accessOrderMap.put("P1", "Valhalla");
        accessOrderMap.put("P2", "Panama");
        accessOrderMap.put("P3", "Loom");
        accessOrderMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        accessOrderMap.get("P1");
        accessOrderMap.get("P3");
        accessOrderMap.get("P2");
        System.out.println("======");
        accessOrderMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        accessOrderMap.put("P4", "Mission");
        System.out.println("======");
        accessOrderMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
