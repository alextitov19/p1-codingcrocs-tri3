package com.codingcorcs.demo.Andrew.DataStructure;

import java.util.List;

public class DoubleCircleLinkedList<t> implements LinkedListInterFace<t>{
    int size = 0;
    private Node Head; //first node
    private Node Tail; // last node && current Node


    public DoubleCircleLinkedList(List<t> e) //list copying
    {
        if (!e.isEmpty()) {
            Head = new Node(e.get(0),null);
            Tail= Head;
            size++;
            for (int i=1; i<e.size(); i++)
            {
                add(e.get(i));
            }
        }
    }
    public DoubleCircleLinkedList(t[] array) //array copying
    {
        if (array.length!=0)
        {
            Head = new Node(array[0],null);
            Tail=Head;
            size++;
            for (int i =1; i< array.length; i++)
            {
               add(array[i]);
            }
        }
    }
    public DoubleCircleLinkedList()
    {

    }



    @Override
    public t getNodeData() {
        return Tail.getData();
    }

    @Override
    public t getIndex(int index) {
        return null;
    }

    @Override
    public void add(t object) {
        Tail = new Node(object,Tail);
        Tail.prev.setNext(Tail);
        Tail.setNext(Head); //Current Node Pointing to Head
        Head.setPrev(Tail); // Head pointing To Tail
        size++;
    }

    @Override
    public void set(int index, t object) {

    }

    @Override
    public void add(int index, t object) {

    }

    @Override
    public int getSize() {
        return size;
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
       private t data;
       private Node prev;
        private Node next;
        Node(t data, Node prev){
            this.data = data;
            this.prev=prev;
        }
        Node(t data, Node prev, Node next){

        }
        void setNext(Node next){
            this.next = next;
        }
        void setPrev(Node prev){
            this.prev = prev;
        }
        t getData()
        {
            return data;
        }
        Node getPrev()
        {
            return prev;
        }

    }
}
