package com.codingcorcs.demo.MiniLabs.Andrew.Sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * the bubble sort is the most basic sort and intuitive as every element is compared in every pass
 * o(n^2) every time
 */
public class BubbleSort extends Sorts{
    @Override
    public void sort(int[] array) {
        for (int i =0; i< array.length-1; i++){ //dont need last index
            for (int j=0; j<array.length-i-1; j++){ // each pass one digit is set and dont need to look at last index
                if (array[j] >array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    @Override
    public void sort(Object[] array) {
            for (int i=0; i<array.length-1; i++){
                for (int j=0; j<array.length-i-1; j++){
                    if (array[j].toString().compareTo(array[j+1].toString())>0){
                        Object temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
    }

    public static void main(String[] args) {
        long nanoToMill = 1000000;
        int[] array;
       array = new Random().ints(60).toArray();
        System.out.println(Arrays.toString(array));
        long time = System.nanoTime();
        new BubbleSort().sort(array);
        float totaltime = System.nanoTime() - time;
        System.out.println(Arrays.toString(array));
        System.out.println("time(mil seconds): " + totaltime/nanoToMill);
        Object[] objects = new Object[3];
        objects[0] = new String("thing");
        objects[1] = 230.25;
        objects[2] = "not a number";
        new BubbleSort().sort(objects);
        System.out.println(Arrays.toString(objects));
    }
}
