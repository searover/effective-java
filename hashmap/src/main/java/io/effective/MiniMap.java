package io.effective;

/**
 * @author searover
 */
public interface MiniMap<K, V> {
    V put(K k, V v);

    V get(K k);

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
