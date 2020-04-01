package com.uladkaminski.sorting;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int[] array = arrayCopy(arr);
        if (array.length <= 1) {
            return array;
        }

        mergeSort(array, array.length);
        return array;
    }

    private void mergeSort(int[] array, int high) {
        if (high < 2) return;
        int mid = high / 2;
        int[] left = new int[mid];
        int[] right = new int[high - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, high - mid);

        mergeSort(left, mid);
        mergeSort(right, high - mid);

        merge(array, left, right, mid, high - mid);


    }

    private void merge(int[] array, int[] left, int[] right, int leftIndex, int rightIndex) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftIndex && j < rightIndex) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftIndex) {
            array[k++] = left[i++];
        }

        while (j < rightIndex) {
            array[k++] = right[j++];
        }

    }
}
