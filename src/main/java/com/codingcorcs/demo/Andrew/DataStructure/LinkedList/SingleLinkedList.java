package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.List;
import java.util.Set;

public class SingleLinkedList<t> implements LinkedListInterFace<t>{
    int size =0;
    private Node head;
    private Node tail;


     //default constructor
    public SingleLinkedList()
    {

    }
    public SingleLinkedList(t[] array)
    {
        if (array.length>0) {
            for (t type: array){
                add(type);
            }
        }
        else{
            throw new IllegalStateException("empty array given");
        }
    }
    public SingleLinkedList(List<t> list)
    {
            if (!list.isEmpty()){
                for (t type: list){
                    add(type);
                }
            }else throw new IllegalStateException("empty List given");
    }
    public SingleLinkedList(Set<t> set)
    {
            if (!set.isEmpty()) {
                for (t type : set){
                    add(type);
                }
            }else throw new IllegalStateException("empty set given");
    }





    @Override
    public t getNodeData() {
        return null;
    }

    @Override
    public t getIndex(int index) {
        return null;
    }

    @Override
    public void add(t object) {
        if (size>0) {
            tail.setNext(new Node(object));
            tail = tail.getNext();
        }else{
            head = new Node(object);
            tail=head;
        }
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
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void delete(int index) {

    }

    private class Node{
       private Node Next;
       private t data;

       Node(t data)
       {
           this.data= data;
       }
       Node(t data, Node next)
       {
            this.data = data;
            this.Next = next;
       }

        public void setData(t data) {
            this.data = data;
        }

        public void setNext(Node next) {
            Next = next;
        }

        public t getData() {
            return data;
        }

        public Node getNext() {
            return Next;
        }
    }
}
