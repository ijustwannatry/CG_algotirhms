import static utils.NanoSecConverter.printTime;

import java.util.Arrays;
import java.util.Random;
import search_.BinarySearch;
import search_.LinearSearch;
import search_.Searcher;
import sort_.Sorter;
import utils.ArraysGenerator;


public class Search {

    public static void main(String[] args) {
        int size = 100_000;
        Random random = new Random(System.nanoTime());
        System.out.println("Generating...");
        int[] arr = ArraysGenerator.sortedArray(size);
//        int[] arr = ArraysGenerator.randomArray(size);
        System.out.println("Generating finished");
        int number = arr[random.nextInt(size)];
//        System.out.println("We are looking for " + number);
//        System.out.print("Position is: ");

        showResult(new LinearSearch(), arr, number);
        showResult(new LinearSearch(), arr, number);
        showResult(new LinearSearch(), arr, number);
        showResult(new BinarySearch(), arr, number);
        showResult(new BinarySearch(), arr, number);



    }


    static void showResult(Searcher searcher, int[] arr, int number) {
        if (arr.length < 30) {
            System.out.println("Before sorting");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Sorter " + searcher.getClass().getSimpleName() + " start sorting");
        long start = System.nanoTime();
        System.out.println("We are looking for " + number);
        System.out.print("Position is: ");
        System.out.println(searcher.search(arr, number));
        long finish = System.nanoTime() - start;
        System.out.println("Sorter " + searcher.getClass().getSimpleName() + " has finished sorting");
        printTime(finish);
        if (arr.length < 30) {
            System.out.println("After sorting");
            System.out.println(Arrays.toString(arr));
        }
    }
}

