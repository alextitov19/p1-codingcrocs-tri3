package com.codingcorcs.demo.MiniLabs.Jett;

import java.util.Arrays;

public class InsertionRecursion {
    public int[] insertionSort(int arr[]) {
        int [] array = arr.clone();
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        InsertionRecursion is = new InsertionRecursion();
        is.insertionSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}