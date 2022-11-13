package io.example.patterns.flyweight.cases;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luxz
 * @date 2022/11/13-17:09
 */
public class WebsiteFactory {
    private Map<String, Website> websites = new HashMap<>();

    public Website getWebsite(String key) {
        if (!websites.containsKey(key)) {
            websites.put(key, new ConcreteWebsite(key));
        }
        return websites.get(key);
    }

    public int getWebsiteCount() {
        return websites.size();
    }
}
