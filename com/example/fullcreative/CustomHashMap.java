package com.example.fullcreative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
if size is 0.75*capacity -> capacity is doubles
(offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the lookup cost)
 */

public class CustomHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Serializable,Cloneable {



    static final int default_size = 16;
    // used when higher value is specified in the constructor
    static final int max_capacity = 1 << 30;
    static final float default_load_factor = 0.75f;
    int size,capacity;
    // interface that provides access to entries in map
    Entry<K,V>[] table;
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
        this.capacity = capacity;
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

    public int hash(K key){

        int hash = this.getAscii(key.toString());
        return hash;
    }

    public int index(int hash){

        return hash % this.capacity;
    }

    public int getAscii(String key){

        int ascii = 0;

        char[] ch = key.toCharArray();
        for(char c : ch){
            int number = (int)c;
            ascii = ascii + number;
        }
        return ascii;

    }

    public V put(K key, V value){

        int hash =  hash(key);
        int index = index(hash);
        Entry<K,V> e = table[index];


        for(Entry<K,V> entry = e; entry != null ; entry = entry.next()){
            if(entry.getKey().equals(key)){
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }

        if(e == null) {
            table[index] = new Entry<>(key, value, hash, null);
        }else{
            table[index] = new Entry<>(key,value,hash,e);
        }
        size++;
        if(size >= threshold){
            this.resize();
        }

        return null;

    }

    public void resize(){
        capacity = 2*capacity;
        System.out.println("Resize required");

        if(capacity > max_capacity){
            capacity = max_capacity;
        }

        Entry[] newTable = new Entry[capacity];

            Entry[] src = table;
            int newCapacity = newTable.length;
            for (int j = 0; j < src.length; j++) {
                Entry e = src[j];
                if (e != null) {
                    src[j] = null;
                    do {
                        Entry next = e.next;
                        int i = this.index(e.hash);
                        e.next = newTable[i];
                        newTable[i] = e;
                        e = next;
                    } while (e != null);
                }
            }

            table = newTable;
            threshold = (int) (capacity*loadFactor);
//        Entry<K,V> newEntry =
    }

    public void clear(){

        for (int i = 0; i < table.length; i++){

            Entry<K,V> e = table[i];
            if(e != null) {
                do {
                    Entry<K, V> enext = e.next();
                    e = null;
                    e = enext;
                } while (e != null);
            }

            table[i] = null;
        }

        size = 0;
    }

    @Override
    public boolean containsValue(@Nullable Object value) {

        for(int i=0;i<table.length;i++) {
            Entry<K, V> entry = table[i];

            if (entry != null) {
                do {
                    if (entry.getValue().equals(value)) {
                        return true;
                    } else {
                        entry = entry.next();
                    }
                } while (entry != null);
            }
        }

        return false;

    }

    @Override
    public boolean containsKey(@Nullable Object key) {

        int hash = this.hash((K) key);
        int index = this.index(hash);
        Entry<K,V> e = table[index];
        for(Entry<K,V> entry = e; entry != null ; entry = entry.next()){
            if(entry.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public V get(@Nullable Object key) {

        int hash = this.hash((K) key);
        int index = this.index(hash);
        Entry<K,V> e = table[index];
        for(Entry<K,V> entry = e; entry != null ; entry = entry.next()){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }

        return null;

    }

    @Nullable
    @Override
    public V remove(@Nullable Object key) {
        V value = null;
        int hash = this.hash((K) key);
        int index = this.index(hash);
        Entry<K,V> e = table[index];
        Entry<K,V> pre = null;
        for(Entry<K,V> entry = e; entry != null ; entry = entry.next()){
            if(entry.getKey().equals(key)){

                if(entry.next() == null){
                    System.out.println("In the vertical block");
                    value = entry.getValue();
                    table[this.index(this.hash(entry.getKey()))] = null;
                }
                else{
                    //Entry<K,V> next = entry.next();
                    if(pre != null){

                        System.out.println("In the block somwhere middle in horizontal");
                        pre.next = entry.next();
                        value = entry.getValue();
                        table[this.index(this.hash(entry.getKey()))] = null;

                    }else{
                        System.out.println("In the block at start of horizontal");
                        table[index] = entry.next();
                        value = entry.getValue();
                        table[this.index(this.hash(entry.getKey()))] = null;
                    }
                }
                size--;
                break;
            }
            pre = entry;
        }

        return value;
    }

    @NonNull
    @Override
    public Collection<V> values() {

        Collection<V> values = new ArrayList<>();

        for(int i=0;i<table.length;i++) {
            Entry<K, V> entry = table[i];
            if (entry != null) {
                do {
                    values.add(entry.getValue());

                } while (entry.next() != null);
            }

        }
        return values;
    }

    @NonNull
    @Override
    public String toString() {

        String hashmap = "";

        for(int i =0;i<table.length;i++) {
            Entry<K, V> entry = table[i];
            if (entry != null) {
                do {
                    hashmap = hashmap + "Key " + entry.getKey() + " Value " + entry.getValue() + "\n";

                } while (entry.next() != null);

            }
        }
        return hashmap;

    }

    @NonNull
    @Override
    public Set<Map.Entry<K, V>> entrySet() {

        Set<Map.Entry<K,V>> set = new Set<Map.Entry<K, V>>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Map.Entry<K, V> kvEntry) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Map.Entry<K, V>> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        return set;
    }

//    @Nullable
//    @Override
//    public V getOrDefault(@Nullable Object key, @Nullable V defaultValue) {
//        return null;
//    }

    //perform chaining so need a next method also
    static class Entry<K,V> implements Map.Entry<K,V>{

        final K key;
        V value;
        final int hash;
        Entry<K,V> next;

        Entry(K key, V value, int hash, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.hash = hash;
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

        @Override
        public V setValue(V v) {
            V oldValue = value;
            value = v;
            return  oldValue;
        }

//        public boolean equal(Object object){
//
//            Entry<K,V> entry = (Entry<K, V>) object;
//            Object keyObject = entry.getKey();
//            Object keyCurrent = getKey();
//            if(keyCurrent.equals(keyObject)){
//                Object valueObject = entry.getValue();
//            }
//
//            return false;
//        }

        public Entry<K,V> next(){
            return next;
        }


    }

    //main method is the start point of any program and it has to take string arg from command line always.
    /*

    class StaticBlock {
    static  // java program can be executed without main method by suing static block
    it is executed only once when the class is loaded into the memory by ClassLoader
    {
        System.out.println(
            "This class can be executed without main");
        System.exit(0);
    }
}

     */

    public static void main(String[] args){

        CustomHashMap<Integer,Integer> hashMap = new CustomHashMap<>(4);
        //System.out.println(hashMap.size());
        //System.out.println(hashMap.isEmpty());

       // System.out.println(hashMap.getAscii("12344"));

//        System.out.println(hashMap.hash(234));
//        System.out.println(hashMap.index(153));

        hashMap.put(11,11);
        hashMap.put(12,12);
        hashMap.put(12,13);
        hashMap.put(16,14);
        System.out.println(hashMap.capacity);
        System.out.println(hashMap.size());
        System.out.println(hashMap.containsKey(16));
        System.out.println(hashMap.containsValue(12));
        System.out.println(hashMap.values());
        System.out.println(hashMap.toString());
        hashMap.put(23,15);
        hashMap.put(27,16);
        System.out.println(hashMap.toString());
//        hashMap.clear();
//        System.out.println(hashMap.size());
//        System.out.println(hashMap.toString());
        System.out.println(hashMap.remove(16));
        System.out.println(hashMap.size());
        System.out.println(hashMap.toString());

    }
}