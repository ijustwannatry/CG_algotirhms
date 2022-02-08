package sort;

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

        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] tempLeft = new int[size1];
        int[] tempRight = new int[size2];

        for (int i = 0; i < size1; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int i = 0; i < size2; i++) {
            tempRight[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < size1 && j < size2) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            arr[k] = tempLeft[i];
            k++;
            i++;
        }
        while (j < size2) {
            arr[k] = tempRight[j];
            k++;
            j++;
        }
    }
}
