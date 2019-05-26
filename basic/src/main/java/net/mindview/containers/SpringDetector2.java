package net.mindview.containers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Groundhog2> ghog = Groundhog2.class.getConstructor(int.class);
        Map<Groundhog2, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println(map);
        Groundhog2 gh3 = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh3);
        System.out.println(map.get(gh3));
        System.out.println(map.get(null));
    }
}
