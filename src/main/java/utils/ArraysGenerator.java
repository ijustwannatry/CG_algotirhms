package utils;

import java.util.Random;

public class ArraysGenerator {

    public static int[] randomArray(int size) {
        Random random = new Random(System.nanoTime());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 2);
        }
        return arr;
    }

    public static int[] sortedArray(int size) {
        int k = 0;
        Random random = new Random(System.nanoTime());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = k;
            k = k + random.nextInt(10);
        }
        return arr;
    }

    public static int[] reversedArray(int size) {
        int k = 0;
        Random random = new Random(System.nanoTime());
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = k;
            k = k + random.nextInt(10);
        }
        return arr;
    }
}
