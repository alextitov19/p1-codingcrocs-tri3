package com.codingcorcs.demo.Andrew.DataStructure;

public class DoubleCircleLinkedList<t> implements LinkedListInterFace<t>{
    private Node Head; //first node
    private Node Tail; // last node && current Node


    @Override
    public t getNode() {
        return null;
    }

    @Override
    public t getIndex(int index) {
        return null;
    }

    @Override
    public void add(t object) {

    }

    @Override
    public void set(int index, t object) {

    }

    @Override
    public void add(int index, t object) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void delete(int index) {

    }

    /**
     * inner class of Double Circle list
     */
    private class Node{
        t data;
        Node prev;
        Node next;
        Node(t data, Node prev){

        }
        Node(t data, Node prev, Node next){

        }
        void setNext(Node next){
            this.next = next;
        }
        void setPrev(Node prev){
            this.prev = prev;
        }

    }
}
