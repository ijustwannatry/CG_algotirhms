package utils;

public class NanoSecConverter {

    public static void printTime(long millis) {
        long min = (millis / 1000_000_000) / 60;
        long sec = (millis / 1000_000_000) % 60;
        long mil = (millis / 1000_000) % 1000;
        long micro = (millis % 1000_000) / 1000;
        long nano = (millis % 1000);
        System.out.printf("Time: %d min. %d sec. %d millis. %d micro. %d nano. %n",
                          min, sec, mil, micro, nano);
    }
}
