package com.codingcorcs.demo.Andrew.DataStructure;

public interface LinkedListInterFace<t> {
    t getNode(); // will return current node
    t getIndex(int index);
    void add(t object); // will add an element to the end of the list
    void set(int index,t object); //set will override the index
    void add(int index,t object);
    int getSize();
    void clear(); //deletes list
    void delete(int index);






}
