import static utils.NanoSecConverter.printTime;

import java.util.Arrays;

import sort_.DualPivotQuickSort;
import sort_.InsertionSort;
import sort_.MergeSort;
import sort_.QuickSort;
import sort_.Sorter;
import utils.ArraysGenerator;

public class Sort {

    public static void main(String[] args) {
        int size = 100_000_00;
        System.out.println("Generating...");
        int[] arr = ArraysGenerator.randomArray(size);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Generating finished");
//        showResult(new InsertionSort(), arr); 14,895 millis
        showResult(new QuickSort(), arr); //10 sec. 539 millis. 891 micro. 100 nano.
        showResult(new DualPivotQuickSort(), arr2); //11 sec. 791 millis. 23 micro. 900 nano

    }










    static void showResult(Sorter sorter, int[] arr) {
        if (arr.length < 30) {
            System.out.println("Before sorting");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Sorter " + sorter.getClass().getSimpleName() + " start sorting");
        long start = System.nanoTime();
        sorter.sort(arr);
        long finish = System.nanoTime() - start;
        System.out.println("Sorter " + sorter.getClass().getSimpleName() + " has finished sorting");
        printTime(finish);
        if (arr.length < 30) {
            System.out.println("After sorting");
            System.out.println(Arrays.toString(arr));
        }
    }
}
