package com.codingcorcs.demo.MiniLabs.Jett;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

interface Timer{
    void wrap();
}

public class MergeSort {

    public static int[] mergeSort(int[] vals){

        if(vals.length == 1){
            return vals;
        }

        int half = vals.length/2;
        int[][] splits = split(vals, half);
        int[] arr1 = splits[0];
        int[] arr2 = splits[1];

        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    public static int[] merge(int[] arr1, int[] arr2){

        int[] result = new int[arr1.length + arr2.length];
        int rI = 0;
        int i1 = 0;
        int i2 = 0;


        while (i1<arr1.length && i2<arr2.length){
            if(arr1[i1] < arr2[i2]){
                result[rI] = arr1[i1];
                i1++;
            }else {
                result[rI] = arr2[i2];
                i2++;
            }
            rI++;
        }

        while (i1 < arr1.length){
            result[rI] = arr1[i1];
            i1++;
            rI++;
        }

        while (i2 < arr2.length){
            result[rI] = arr2[i2];
            i2++;
            rI++;
        }

        return result;
    }

    public static int[][] split(int arr[], int i){
        int[] arr1 = new int[i];
        int[] arr2 = new int[arr.length - i];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
        return new int[][]{arr1, arr2};
    }


    public static Long logTime(Timer timer){
        long start = System.nanoTime();
        timer.wrap();
        return System.nanoTime()-start;
    }

    static int CEIL = 5000;
    public static ArrayList<Long> sortMany(int n){
        Random rand = new Random();
        int[] arr = new int[0];
        ArrayList<Long> times = new ArrayList<Long>();

        for(int i =1; i<=n;i++){
            arr = Arrays.copyOf(arr, arr.length+1);
            arr[arr.length-1] = rand.nextInt(CEIL);

            int[] unsorted = arr;
            long time = MergeSort.logTime(new Timer() {
                @Override
                public void wrap() {
                    int[] sorted = MergeSort.mergeSort(unsorted);
                    //System.out.println(Arrays.toString(unsorted) + " => " + Arrays.toString(sorted));
                }
            });
            times.add(time);
        }

        return times;
    }

    public static String[] getExampleSort(int length){
        Random rand = new Random();
        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i] = rand.nextInt(100);
        }
        int[] sorted = MergeSort.mergeSort(arr);
        return new String[]{
                "Unsorted: " + Arrays.toString(arr),
                "Sorted: " + Arrays.toString(sorted)
        };
    }

    public static void main(String[] args) {
        int[] vals = new int[]{5,2,8,23,6,7,123,-1,435,2,7,2,7,8,90};

        MergeSort.sortMany(10000);
    }

}
