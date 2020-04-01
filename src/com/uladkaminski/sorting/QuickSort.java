package com.uladkaminski.sorting;

public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int[] array = arrayCopy(arr);
        if (array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, high);
        return i + 1;
    }

    private void swapElements(int[] arr, int i, int j) {
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }


}
