import java.util.Arrays;
import java.util.Random;
import search.BinarySearch;
import search.LinearSearch;
import sort.InsertionSort;
import sort.QuickSort;
import utils.ArraysGenerator;

public class SortedVsUnsorted {

    public static void main(String[] args) {
        int size = 100_000_000;
        Random random = new Random(System.nanoTime());
        System.out.println("Generating...");
//        int[] arr = ArraysGenerator.sortedArray(size);
        int[] arr = ArraysGenerator.randomArray(size);
//        int[] arr1 = Arrays.copyOf(arr, size);
        System.out.println("Generating finished");
        int number = arr[random.nextInt(size)];
        System.out.println("We are looking for " + number + " with linear search");
        System.out.print("Position is: ");
        long start = System.nanoTime();

        System.out.println(new LinearSearch().search(arr, number));
        System.out.println(new LinearSearch().search(arr, number + 10));

        printTime(System.nanoTime() - start);

        System.out.println("We are looking for " + number + " with sorting + binary search");
        System.out.print("Position is: ");
        start = System.nanoTime();

        new QuickSort().sort(arr);
        System.out.println(new BinarySearch().search(arr, number));
        System.out.println(new BinarySearch().search(arr, number + 10));

        printTime(System.nanoTime() - start);


    }

    private static void printTime(long millis) {
        long min = (millis / 1000_000_000) / 60;
        long sec = (millis / 1000_000_000) % 60;
        long mil = (millis / 1000_000) % 1000;
        long micro = (millis % 1000_000) / 1000;
        long nano = (millis % 1000);
        System.out.printf("Time: %d min. %d sec. %d millis. %d micro. %d nano. %n",
                          min, sec, mil, micro, nano);
    }
}
