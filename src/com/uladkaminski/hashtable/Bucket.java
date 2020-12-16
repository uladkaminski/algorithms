package com.uladkaminski.hashtable;

import java.util.Objects;

public class Bucket {
    private Object key;
    private Object value;
    private Bucket next;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(key, bucket.key) &&
                Objects.equals(value, bucket.value) &&
                Objects.equals(next, bucket.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
