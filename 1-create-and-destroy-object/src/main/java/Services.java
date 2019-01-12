import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerProvider(Provider p) {
        providers.put(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return providers.get(DEFAULT_PROVIDER_NAME).newService();
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException("No provider register with name: " + name);
        return p.newService();
    }
}
