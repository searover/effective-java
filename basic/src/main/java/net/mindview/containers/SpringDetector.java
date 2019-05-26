package net.mindview.containers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Grounhog> ghog = Grounhog.class.getConstructor(int.class);
        Map<Grounhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println(map);
        Grounhog gh3 = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh3);
        System.out.println(map.get(gh3));
    }
}
