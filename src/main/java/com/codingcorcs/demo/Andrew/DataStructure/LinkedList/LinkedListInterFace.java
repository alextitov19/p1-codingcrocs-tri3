package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.Comparator;

public interface LinkedListInterFace<t> extends Iterable<t>{
    /**
     *
     * @return <font color='red'>given generic by the user</font>
     */
    t getNodeData(); // will return current node

    /**
     * @param index <font color='red'>the index used to get the generic</font>
     * @return <font color='red'>given generic by the user</font>
     *
     */
    t getIndex(int index);

    /**
     *
     * @param object <font color='red'>object passed to be stored</font>
     */
    void add(t object); // will add an element to the end of the list

    /**
     * overrides the index given with the object passed
     * @param index - <font color='red'>the storage point used to store object</font>
     * @param object <font color='red'>the object passed to the linked list</font>
     */
    void set(int index,t object); //set will override the index

    /**
     * inserts the object at the given index does not override anything
     * @param index <font color='red'>the given index to insert the object</font>
     * @param object <font color='red'>data given by the user</font>
     */
    void add(int index,t object);

    /**
     *
     * @return <font color='red'>the size of the linkedList</font>
     */
    int getSize();

    /**
     * <font color='red'>deletes whole list</font>
     */
    void clear(); //deletes list

    /**
     *
     * @param index <font color='red'>the index to be deleted</font>
     */
    void delete(int index);
    void delete();

    /**
     *
     * @return <font color='red'>generic data type given by user of the deleted node</font>
     */
    t remove();

    /**
     *
     * @param index the index to be deleted
     * @return <font color='red'>generic data type give by the user of the give index to be deleted</font>
     */
    t remove(int index);

    /**
     * <font color='red'>function to sort data via toString()</font>
     */
    void sort();

    /**
     *
     * @param comparator <font color='red'>the comparator used by method to sort the data in the give list must be of t type</font>
     */
    void sort(Comparator<t> comparator);






}
