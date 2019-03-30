package io.effective;

import java.util.ArrayList;
import java.util.List;

public class MiniHashMap<K, V> implements MiniMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;
    private float defaultLoadFactor;
    private int entryUseSize;

    private Entry[] table = null;

    public MiniHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MiniHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        if (defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + defaultInitialCapacity);
        }
        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + defaultLoadFactor);
        }
        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLoadFactor = defaultLoadFactor;
        table = new Entry[defaultInitialCapacity];
    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        if (entryUseSize >= defaultInitSize * defaultLoadFactor) {
            resize(2 * defaultInitSize);
        }
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else {
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<>(k, v, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    private void resize(int length) {
        Entry[] newTable = new Entry[length];
        defaultInitSize = length;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry[] newTable) {
        List<Entry<K, V>> entryList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryList.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }
        if (newTable.length > 0) {
            table = newTable;
        }
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    private int hash(K k) {
        int h;
        return k == null ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[index];
            do {
                if (k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.value;
                }
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }

    class Entry<K, V> implements MiniMap.Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {

        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
