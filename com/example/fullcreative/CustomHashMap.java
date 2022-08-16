package com.example.fullcreative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class CustomHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Serializable,Cloneable {


    static final int default_size = 16;
    // used when higher value is specified in the constructor
    static final int max_capacity = 1 << 30;
    static final float default_load_factor = 0.75f;
    int size;
    // interface that provides access to entries in map
    Entry[] table;
    int threshold; // capacity*load to resize
    float loadFactor;


    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Initial capacity has to be greater than zero");
        if (initialCapacity > max_capacity)
            initialCapacity = max_capacity;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

        // Find a power of 2 >= initialCapacity
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        this.loadFactor = loadFactor;
        threshold = (int)(capacity * loadFactor);
        table = new Entry[capacity];
    }

    public CustomHashMap(int initialCapacity) {
        this(initialCapacity, default_load_factor);
    }

    public CustomHashMap(){
        this(default_size,default_load_factor);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    @NonNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Nullable
    @Override
    public V getOrDefault(@Nullable Object key, @Nullable V defaultValue) {
        return null;
    }
}
