package com.codingcorcs.demo.Andrew.ArrayList;

import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.Animals;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.ListOfData;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.People;

import java.util.*;

public class MyArrayList<t> implements Iterable<t>{
    private int size;
    private Object array[]; // not allowed to create arrays


    MyArrayList(){
        array= new Object[10];
    }

    MyArrayList(int initialCapacity){
        array = new Object[initialCapacity];
    }
    MyArrayList(Collection<t> data){
        array = Arrays.copyOf(data.toArray(),data.size());
        size = array.length;
    }
    public void add(t data){
        if (array.length == size) {
            growArray();
        }
        array[size] = data;
        size++;
    }
    private void growArray(){
        Object[] temp = new Object[array.length*2]; // grows the array by two
        System.arraycopy(array,0,temp,0,array.length); // like memcpy mehtod found in c
        array=temp; //old fashion c style array copy method lol expect the whole free(array) thing, java :)
    }
    private void checkIndex(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("index given:" + index+" does not fit restriction of >=0 or < index");
        }
    }
    public void add(t data, int index){
        checkIndex(index);
            if (array.length==size){
                growArray();
            }
            System.arraycopy(array,index,array,index+1,(size-index));//size minus index get us the length/number of elements between index and endpoint
        array[index] = data;
        size++;

    }
    public void delete(int index){
        checkIndex(index);
        if (index==size-1){
            array[index] = null;
        }else {
            System.arraycopy(array, index + 1, array, index, size - (index + 1));
        }
        array[size--]=null;
    }
    @SafeVarargs
    public final void addAll(t... data){
        for (t d:data){
            add(d);
        }
    }
    public int size(){
        return size;
    }
    @SuppressWarnings("unchecked")
    public t get(int index){
        checkIndex(index);
        return (t) array[index];
    }

    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.add(12);
        myArray.addAll(Arrays.asList(14, 15,16,12));
        System.out.println(myArray.size()); //size is number of elements in the array not the capacity
        MyArrayList<Integer> arrayList= new MyArrayList<>();
        arrayList.addAll(12,15,16,17,18);
        System.out.println(arrayList.size());
        arrayList.delete(4);
        System.out.println(arrayList.size());

    }


    @Override
    public Iterator<t> iterator() {
        return new Iter();
    }
    private class Iter implements Iterator<t>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        @SuppressWarnings("unchecked") //gets ride of error casting of object to t type data
        public t next() {
            return (t) array[currentIndex++];//post increment after getting index
        }
    }
}
