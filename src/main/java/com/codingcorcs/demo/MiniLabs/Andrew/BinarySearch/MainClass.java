package com.codingcorcs.demo.MiniLabs.Andrew.BinarySearch;

public class MainClass implements Comparable<MainClass>{

    public MainClass(int value){
        this.value = value;
    }
    int value;
    @Override
    public int compareTo(MainClass o) {
        return this.value>o.value?1 : this.value==o.value?0 : -1;
    }
}
