package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SingleLinkedList<t> implements LinkedListInterFace<t>{
    int size =0;
    private Node head;
    private Node tail;


    /**
     * <p color="red">default constructor</p>
     */
    public SingleLinkedList()
    {

    }

    /**
     * <p color="red">constructor for SingleLinked List</p>
     * @param array the array used to fill LinkedList list
     * @throws IllegalStateException if array is null
     */
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

    /**
     * <p color='red'>constructor for SingleLinkedList</p>
     * @param list the listed used to fill LinkedList
     * @throws IllegalStateException if list is emtpy
     */
    public SingleLinkedList(List<t> list)
    {
            if (!list.isEmpty()){
                for (t type: list){
                    add(type);
                }
            }else throw new IllegalStateException("empty List given");
    }

    /**
     * <p color='red'>constructor for SingleLinkedList</p>
     * @param set the set used to fill the LinkedList
     * @throws IllegalStateException if empty set is given
     */
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
        if (index==0)
        {
            head.setData(object);
        }else{
            int counter=1;
            Node indexOfCounter = head.getNext();
            while (counter!=index)
            {
                indexOfCounter = indexOfCounter.getNext();
                counter++;
            }
            indexOfCounter.setData(object);
        }

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

    @Override
    public void delete() {

    }

    @Override
    public t remove() {
        return null;
    }

    @Override
    public t remove(int index) {
        return null;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<t> comparator) {

    }

    @Override
    public Iterator<t> iterator() {
        return new iter();
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
    private class iter implements Iterator<t>{
        Node current;
        iter(){
            current = head;
        }
        @Override
        public boolean hasNext() {
           return current.getNext()!=null;
        }

        @Override
        public t next() {
            t data = current.getData();
            current= current.getNext();
            return data;
        }
    }
}
