package com.codingcorcs.demo.MiniLabs.Jett;
import java.util.Arrays;



public class InsertionRecursion {

    public Integer[] sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String characterSort(Integer[] arr) {
        Integer[] arrr = sort(arr);
        String answer = "";
        answer+="[";
        for (int i = 0; i < arrr.length - 1; i++) {
            answer+=arrr[i];
            answer+=", ";
        }
        answer+=arrr[arrr.length-1];
        answer+="]";
        return answer;
    }

    public String characterSort(String[] arr) {
        String[] arrr = sort(arr);
        String answer = "";
        answer+="[";
        for (int i = 0; i < arrr.length - 1; i++) {
            answer+=arrr[i];
            answer+=", ";
        }
        answer+=arrr[arrr.length-1];
        answer+="]";
        return answer;
    }


    public String[] sort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (key.compareTo(arr[j]) > 0) {
                    break;
                }
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public Summer[] sort(Summer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Summer key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (key.getHeading().compareTo(arr[j].getHeading()) > 0) {
                    break;
                }
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
