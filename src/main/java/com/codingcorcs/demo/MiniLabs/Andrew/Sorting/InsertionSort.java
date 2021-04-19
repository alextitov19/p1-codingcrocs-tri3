package com.codingcorcs.demo.MiniLabs.Andrew.Sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort extends Sorts{
    @Override
    public void sort(int[] array) {
        int key,j;
        for (int i=1; i<array.length; i++){
              key = array[i];
              j = i-1;
             while ( j>=0 && key<array[j]){
                 array[j+1] = array[j];
                 j--;
             }
             array[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] array;
        long nanoToMill = 1000000;
        array = new Random().ints(60).toArray();
        System.out.println(Arrays.toString(array));
        long time = System.nanoTime();
        new InsertionSort().sort(array);
        float totalTime= System.nanoTime()-time;
        System.out.println(Arrays.toString(array));
        System.out.println("Time(mill): " + totalTime/nanoToMill);
    }
}
