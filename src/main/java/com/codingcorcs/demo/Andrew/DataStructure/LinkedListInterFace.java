package com.codingcorcs.demo.Andrew.DataStructure;

public interface LinkedListInterFace<t> {
    /**
     *
     * @return given generic by the user
     */
    t getNodeData(); // will return current node

    /**
     * @param index the index used to get the generic
     * @return given generic by the user
     *
     */
    t getIndex(int index);

    /**
     *
     * @param object object passed to be stored
     */
    void add(t object); // will add an element to the end of the list

    /**
     * overrides the index given with the object passed
     * @param index - the storage point used to store object
     * @param object the object passed to the linked list
     */
    void set(int index,t object); //set will override the index

    /**
     * inserts the object at the given index does not override anything
     * @param index the given index to insert the object
     * @param object data given by the user
     */
    void add(int index,t object);

    /**
     *
     * @return the size of the linkedList
     */
    int getSize();

    /**
     * deletes linklist
     */
    void clear(); //deletes list

    /**
     *
     * @param index the index to be deleted
     */
    void delete(int index);






}
