package com.codingcorcs.demo.MiniLabs.Andrew.Sorting;

import java.util.Arrays;
import java.util.Random;

public class SelctionSort extends Sorts{
    @Override
    public void sort(int[] array) {
        int indexOfj,min;
        for (int i =0; i< array.length-1; i++){
            min=array[i];
            indexOfj=i;
            for (int j = i; j<array.length; j++){
                    if (array[j]<min){
                        min=array[j];
                        indexOfj=j;
                    }
            }
            int temp = array[i];
            array[i] = array[indexOfj];
            array[indexOfj] = temp;
        }
    }

    public static void main(String[] args) {
        long nanoToMill = 1000000;
        int[] array;
        long time;
        float totalTime;
        array = new Random().ints(62).toArray();
        System.out.println(Arrays.toString(array));
        time = System.nanoTime();
        new SelctionSort().sort(array);
        totalTime = System.nanoTime()-time;
        System.out.println(Arrays.toString(array));
        System.out.println("Time(time in Mill): " +totalTime/nanoToMill);
    }
}
