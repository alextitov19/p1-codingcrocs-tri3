package com.codingcorcs.demo.MiniLabs.Andrew.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MergeSort<T extends Comparable<T>> {


  public void mergeSort(T[] array, int l, int r){
      if (l<r){
          int m = (l+r)/2;
          mergeSort(array,l,m);
          mergeSort(array,m+1,r);
          merge(array,l,m,r);
      }
  }
  @SuppressWarnings("unchecked")
  public void merge(T[] array, int l, int m, int r){
      int n1 = m-l+1;
      int n2 = r-m;
      Object[] half1 = new Object[n1];
      Object[] half2 = new Object[n2];
      for (int i =0; i<n1; i++){
          half1[i]=array[i+l];
      }
      for (int j=0; j< n2; j++){
          half2[j] = array[m+1+j];
      }
      int i,j,k;
      i=0;
      j=0;
      k=l;
      while (i<n1 && j<n2){
          if (((T)half1[i]).compareTo((T)half2[j])<=0){
              array[k]=(T)half1[i];
              i++;
          }else{
              array[k] = (T) half2[j];
              j++;
          }
          k++;
      }
      while (i<n1){
          array[k]= (T) half1[i];
          k++;
          i++;
      }
      while (j<n2){
          array[k] = (T) half2[j];
          k++;
          j++;
      }
  }
    public void mergeSort(List<T> array, int l, int r){
        if (l<r){
            int m = (l+r)/2;
            mergeSort(array,l,m);
            mergeSort(array,m+1,r);
            merge(array,l,m,r);
        }
    }
    @SuppressWarnings("unchecked")
    public void merge(List<T> array, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        Object[] half1 = new Object[n1];
        Object[] half2 = new Object[n2];
        for (int i =0; i<n1; i++){
            half1[i]=array.get(i+l);
        }
        for (int j=0; j< n2; j++){
            half2[j] = array.get(m+1+j);
        }
        int i,j,k;
        i=0;
        j=0;
        k=l;
        while (i<n1 && j<n2){
            if (((T)half1[i]).compareTo((T)half2[j])<=0){
                array.set(k,(T)half1[i]);
                i++;
            }else{
                array.set(k,(T) half2[j]);
                j++;
            }
            k++;
        }
        while (i<n1){
            array.set(k,(T) half1[i]);
            k++;
            i++;
        }
        while (j<n2){
            array.set(k,(T) half2[j]);
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{6,5,12,10,9,1};
        MergeSort<Integer> thing = new MergeSort<>();
        thing.mergeSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
        List<Integer> list1 = new ArrayList<>(List.of(6,5,12,10,9,1));
        thing.mergeSort(list1,0,list1.size()-1);
        System.out.println(list1);
    }

}
