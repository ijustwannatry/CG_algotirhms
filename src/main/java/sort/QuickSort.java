package sort;

public class QuickSort implements Sorter {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {

//            int pivot = pivotHigh(arr, low, high);
            int pivot = pivotMid(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int pivotHigh(int[] arr, int low, int high) {
        int pi = arr[high];
        int cursor = low; // smaller element index
        for (int j = low; j < high; j++) {
            // check if current element is less than or equal to pi
            if (arr[j] <= pi) {
                swap(arr, cursor, j);
                cursor++;
            }
        }
        swap(arr, cursor, high);
        return cursor;
    }

    private int pivotLow(int[] arr, int low, int high) {
        int pi = arr[low];
        int cursor = low + 1; //skip pivot
        for (int j = low + 1; j <= high; j++) {
            // check if current element is less than or equal to pi
            if (arr[j] < pi) {
                swap(arr, cursor, j);
                cursor++;
            }
        }
        cursor--;
        // swap arr[i+1] and arr[high] (or pi)
        swap(arr, cursor, low);
        return cursor;
    }

    private int pivotMid(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int pi = arr[mid];
        int l = low;
        int r = high;
        while (l <= r) {
            while (arr[l] < pi) {
                l++;
            }
            while (arr[r] > pi) {
                r--;
            }
            if (l <= r) {
                swap(arr, r, l);
                l++;
                r--;
            }
        }
        return l;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}