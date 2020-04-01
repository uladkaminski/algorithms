package com.uladkaminski.sorting;

public interface Sort {
    int[] sort(int[] arr);

    default int[] arrayCopy(int[] arr) {
        int[] array = new int[arr.length];
        System.arraycopy(arr, 0, array, 0, arr.length);
        return array;
    }
}
