package com.codingcorcs.demo.MiniLabs.Andrew.Sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * best case o(n) no sorts
 * worst case 0(n^2)
 */
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

    @Override
    public void sort(Object[] array) {
            Object key;
            int j;
            for (int i=1; i<array.length; i++){
                key= array[i];
                j=i-1;
                while (j>=0 && array[j].toString().compareTo(key.toString())>0){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = key;
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
        Object[] objects = new Object[3];
        objects[0] = new String("thing");
        objects[1] = 230.25;
        objects[2] = "not a number";
        new InsertionSort().sort(objects);
        System.out.println(Arrays.toString(objects));
    }
}
