package com.evercompliant.scrap;


import java.util.Arrays;
import java.util.Random;

public class RuleOfFive {
    private static final int SIZE = 10000;
    private static final int POOL_SIZE = 10000;
    private static final Random r = new Random();
    private static final int EXP_COUNT = 1000;

    public static void main(String[] args) {

        int acc = 0;
        for (int j = 1; j <= EXP_COUNT; j++) {
            int[] arr = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = r.nextInt(POOL_SIZE);
            }

            int[] fiveArr = genRandomArr(arr, 5);
            Arrays.sort(fiveArr);

            int median = median(arr);
            if (median < fiveArr[0] || median > fiveArr[4]) {
                ++acc;
            }
        }

        System.out.println(String.format("Range violated %d times out of %d experiences (%.2f percent success)",
                acc, EXP_COUNT, 100 - 100  * (double) acc / (double) EXP_COUNT));
    }

    private static int[] genRandomArr(int[] origArr, int size) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = origArr[r.nextInt(origArr.length)];
        }
        return ret;
    }

    private static int median(int[] arr) {
        Arrays.sort(arr);
        int median;
        if (arr.length % 2 == 0)
            median = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        else
            median = arr[arr.length / 2];
        return median;
    }
}
