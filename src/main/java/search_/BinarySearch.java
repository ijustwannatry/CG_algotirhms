package search_;

public class BinarySearch implements Searcher {


    public int search(int[] arr, int number) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == number) {
                return mid;
            }
            if (arr[mid] < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int searchRecursive(int[] arr, int number, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == number) {
            return mid;
        }
        if (arr[mid] < number) {
            return searchRecursive(arr, number, mid + 1, high);
        } else {
            return searchRecursive(arr, number, low, mid - 1);
        }
    }

}
