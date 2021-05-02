package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.*;

public class SingleLinkedList<t> implements LinkedListInterFace<t>{
    int size =0;
    private Node head;
    private Node tail; //this the current node and the tail of the list


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

    /**
     *
     * @param n <font color='green'> Index given by the user </font>
     * @throws IndexOutOfBoundsException <font color='red'>When index given is illegal</font>
     */
    public void checkIndex(int n){
        if (n<0 || n>=size) throw new IndexOutOfBoundsException("The index given("+n+") is out bounds for list size of: "+getSize());
    }





    @Override
    public t getNodeData() {
        return tail.data;
    }

    @Override
    public t getIndex(int index) {
        checkIndex(index);
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
        checkIndex(index);
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
        checkIndex(index);
        if (index==0){
            head= new Node(object,head);
            size++;
            return;
        }
        int counter = 0;
        Node temp = head;
        while(counter<index-1){
            temp=temp.getNext();
            counter++;
        }
        temp.setNext(new Node(object,temp.getNext()));
        size++;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        while (head!=null){
            delete();
        }

    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        if (index==0){
            head=head.getNext(); // java will use trash collection to get rid of the old head node
            size--;
            return;
        }
        if (index==getSize()-1){
            delete();
            size--;
            return;
        }
        Node temp = head;
        int counter = 0;
        while (counter < index-1){
            temp = temp.getNext();
            counter++;
        }
        temp.setNext(temp.getNext().getNext());
        size--;
    }



    @Override
    public void delete() {
        checkSize();
        if (size==1){
            tail=null;
            head=null;
            size--;
            return;
        }
        Node pointer = head;
        while (pointer.getNext()!=tail){
            pointer=pointer.getNext();
        }
        pointer.setNext(null);
        tail=pointer;
        size--;
    }

    /**
     * @throws IllegalStateException <font color='red'>if list is empty and an operation is called that requires it not to be</font>
     */
    private void checkSize(){
        if (getSize()<=0) throw new IllegalStateException("List is empty when a operation was called that required the list not to be");
    }

    /**
     * <p color='yellow'>This is similar to the delete method beside the fact it returns the data of the object removed</p>
     * @return the data of the object returned
     */
    @Override
    public t remove() {
        t data = tail.getData();
        delete();
        return data;
    }

    @Override
    public t remove(int index) {
        checkIndex(index);
        int counter = 0;
        Node temp = head;
        while (counter<index){ // doesnt make sense intuitively but you will get the right index by stopping before the index of
            temp=temp.getNext();
            counter++;
        }
        t data = temp.data;
        delete(index);
        return data;
    }

    /**
     * <p color='yellow'>This sort is a selection sort that iterates forward </p>
     */
    @Override
    public void sort() {
        checkSize();
            Node Pointer1 = head;
            while (Pointer1.getNext()!=null){
                Node indexer = Pointer1.getNext();
                Node minNode = Pointer1;
                t min = Pointer1.getData();
                while (indexer!=null){
                    if (indexer.getData().toString().compareTo(min.toString())<0){
                        min = indexer.getData();
                        minNode=indexer;
                    }
                    indexer= indexer.getNext();
                }
                if (minNode!=Pointer1){
                    minNode.setData(Pointer1.getData());
                    Pointer1.setData(min);
                }
                Pointer1= Pointer1.getNext();
            }
    }


    /**
     * <p color='yellow'>This sort is a selection sort that iterates forward </p>
     * @param comparator <font color='red'>the comparator used by method to sort the data in the give list must be of t type</font>
     */
    @Override
    public void sort(Comparator<t> comparator) {
        checkSize();
        Node Pointer1 = head;
        while (Pointer1.getNext()!=null){
            Node indexer= Pointer1.getNext();
            Node minNode = Pointer1;
            t min = Pointer1.getData();
            while(indexer!=null){
                if (comparator.compare(indexer.getData(),min)<0){
                    minNode = indexer;
                    min= indexer.getData();
                }
                indexer=indexer.getNext();
            }
            if (Pointer1!=minNode){
                minNode.setData(Pointer1.getData());
                Pointer1.setData(min);
            }
            Pointer1= Pointer1.getNext();
        }

    }

    /**
     * adds all the objects into the list great for copying data into the list
     * @param list data to be added into the LinkedList
     */
    @Override
    public void addAll(List<t> list) {
        list.forEach(this::add);
    }


    /**
     * adds all the objects into the list great for copying data into the list
     * @param data varargs that is added to the list
     */
    @SafeVarargs
    @Override
    public final void addAll(t... data) {
        for (t arrayData: data){
            add(arrayData);
        }
    }

    /**
     * This is used by java for the foreach loops both stream api and for enhanced for loops
     * @return <font color='red'>Iterator</font> used by java
     */
    @Override
    public Iterator<t> iterator() {
        return new iter();
    }

    /**
     * private class used by SingleLinkedList to hold data
     */
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

    /**
     * Iterator implantation
     */
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
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        Node pointer = head;
        while (pointer!=null){
            if (pointer.getData()==null){
                builder.append("null");
            }else{
                builder.append(pointer.getData());
            }
            if (pointer.getNext()!=null){
                builder.append(", ");
            }
            pointer = pointer.getNext();
        }
        builder.append("]");
        return  builder.toString();

    }

    /**
     * theory based idea to check on runtime if a class use comparable if so then does some extra logic
     * just an idea that seems to work
     */
    public void Checking(){
        Class<?> object = head.getData().getClass();
        if (Arrays.asList(object.getInterfaces()).contains(Comparable.class)){
            Comparable<t> comparable = (Comparable<t>) head.getData();
            System.out.println("made cast");
            if (comparable.compareTo(head.getData())==0){
                System.out.println("head equals data");
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> thing = new SingleLinkedList<>(new Integer[]{12, 2, 14, 15});
        thing.sort(Integer::compareTo);
        System.out.println(thing);
    }
}
