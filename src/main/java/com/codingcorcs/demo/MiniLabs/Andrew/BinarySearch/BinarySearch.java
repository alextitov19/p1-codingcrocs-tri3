package com.codingcorcs.demo.MiniLabs.Andrew.BinarySearch;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BinarySearch {

    /**
     * @param list the place of storage the user wants to be search
     * @param <t> type the user wants to sort
     * @param x the object the user wants to find
     * @return the index of the object the user wants returns -1 if not found
     */
    public static <t extends Comparable<t>> int BinarySort(List<? extends t> list,t x){
        int mid;
        mid = list.size()/2;
        if (x.compareTo(list.get(mid))==0) return mid;
        if(x.compareTo(list.get(mid))>0){
            return BinarySort(list,++mid,list.size(),x);
        }else{
            return BinarySort(list,0,--mid,x);
        }
    }

    /**
     *
     * @param list the place of storage the user wants to be search
     * @param l low point
     * @param h high point
     * @param x the object the user wants to find
     * @param <t> type the user wants to sort
     * @return the index of the object the user wants returns -1 if not found
     */
    public static <t extends Comparable<t>> int BinarySort(List<? extends t> list,int l,int h, t x){
        if (h>=l){
            int mid =(h-l)/2 +l; //gets the mid point between h and low (6-4)/2 + 4 =5 mid point
            if (x.compareTo(list.get(mid))==0) return mid;
            if (x.compareTo(list.get(mid))>0) return BinarySort(list,++mid,h, x);
            return BinarySort(list, l,--mid , x);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Tester for Binary Sort");
        List<Integer> numberList = new Random().ints(120000).boxed().sorted().collect(Collectors.toList());
        System.out.println((BinarySort(numberList,numberList.get(new Random().nextInt(numberList.size())))));
        List<SecondaryClass> secondaryClasses = new ArrayList<>(List.of(new SecondaryClass(5,"thanks"),new SecondaryClass(12,"hello"),new SecondaryClass(14,"bye"), new SecondaryClass(16,"tag")));
        int x;
        System.out.println(( x=BinarySort(secondaryClasses,new SecondaryClass(14,"bye"))));
        System.out.println(secondaryClasses.get(x));
    }

}
