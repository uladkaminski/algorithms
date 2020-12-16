package com.uladkaminski.hashtable;

public class Hashtable {
    private int size;
    private Object[] objects;

    public Hashtable(int capacity) {
        this.size = 0;
        objects = new Object[capacity];
    }

    public void add(Object key, Object value) {
        int hash = hash(key);




    }

    private int hash(Object object) {
        return object.hashCode() % objects.length;
    }
}
