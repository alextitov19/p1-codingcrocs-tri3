package com.codingcorcs.demo.MiniLabs.Andrew.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Selection sort is o(n^2) as it always checks for a min value after every pass
 */
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

    @Override
    public void sort(Object[] array) {
        int indexofj;
        Object min;
        for (int i = 0; i< array.length-1; i++){
            indexofj=i;
            min=array[i];
            for(int j=i+1; j< array.length; j++){
                if (array[j].toString().compareTo(min.toString())<0){
                    indexofj=j;
                    min=array[j];
                }
            }
            Object temp = array[i];
            array[i]=array[indexofj];
            array[indexofj] = temp;
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
        Object[] objects = new Object[5];
        objects[0] = new String("thing");
        objects[1] = 230.25;
        objects[2] = "not a number";
        objects[3] = 12;
        objects[4] = new ArrayList<>(List.of("Thisispart1","part2","part3"));
        new SelctionSort().sort(objects);
        System.out.println(Arrays.toString(objects));
    }
}
