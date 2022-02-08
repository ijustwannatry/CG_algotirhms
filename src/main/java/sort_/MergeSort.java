package sort_;

import sort_.Sorter;

public class MergeSort implements Sorter {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int l = mid - left + 1;
        int r = right - mid;

        int[] arrL = new int[l];
        int[] arrR = new int[r];

        for (int i = 0; i < l; i++) {
            arrL[i] = arr[left + i];
        }
        for (int i = 0; i < r; i++) {
            arrR[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < l && j < r) {
            if (arrL[i] <= arrR[j]) {
                arr[k] = arrL[i];
                i++;
            } else {
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = arrL[i];
            i++;
            k++;
        }
        while (j < r) {
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }
}

/*
 12 124 52 123
 12 124     52 123
 12    124      52     123
 12 124    52 123

 12 52 123 124
 */
