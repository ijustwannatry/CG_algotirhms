package sort;

public class DualPivotQuickSort implements Sorter {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int[] piv;
            piv = partition(arr, low, high);

            quickSort(arr, low, piv[0] - 1);
            quickSort(arr, piv[0] + 1, piv[1] - 1);
            quickSort(arr, piv[1] + 1, high);
        }
    }

    private int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        int j = low + 1;
        int g = high - 1;
        int k = low + 1;
        int p = arr[low];
        int q = arr[high];

        while (k <= g) {

            if (arr[k] < p) {
                swap(arr, k, j);
                j++;
            } else if (arr[k] >= q) {
                while (arr[g] > q && k < g) {
                    g--;
                }
                swap(arr, k, g);
                g--;

                if (arr[k] < p) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        swap(arr, low, j);
        swap(arr, high, g);

        return new int[] {j, g};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
