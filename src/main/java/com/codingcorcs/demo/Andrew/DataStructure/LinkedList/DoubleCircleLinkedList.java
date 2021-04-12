package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.List;

public class DoubleCircleLinkedList<t> implements LinkedListInterFace<t>{
    int size = 0;
    private Node Head; //first node
    private Node Tail; // last node && current Node


    public DoubleCircleLinkedList(List<t> e) //list copying
    {
        if (!e.isEmpty()) {
            for (t t : e) {
                add(t);
            }
        }
    }
    public DoubleCircleLinkedList(t[] array) //array copying
    {
        if (array.length!=0)
        {
            for (t t : array) {
                add(t);
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
        if (size>0) {
            Tail = new Node(object, Tail);
            Tail.prev.setNext(Tail);
            Tail.setNext(Head); //Current Node Pointing to Head
            Head.setPrev(Tail); // Head pointing To Tail
        }
        else{
            Head = new Node(object,null);
            Tail= Head;
        }
        size++;
    }

    @Override
    public void set(int index, t object) {//java does not have f**king unsigned types why!!!!
        if (index>=getSize() || index<0){
            throw new IndexOutOfBoundsException("index is greater than size of LinkedList or is less than 0!");
        }
        if ((getSize()-1) == index)
        {
            Tail.data=object;
            return;
        }
        if (index==0)
        {
            Head.data=object;
            return;
        }
            Node temp;
            int counter = 1;
            if (index>((getSize()-1)-index)) { // iterate backwards

                temp = Tail.getPrev(); //prev pointer
                while (temp!=Tail)
                {
                    if ((getSize()-1)-counter==index)
                    {
                        temp.data=object;
                        return;
                    }
                    temp = temp.getPrev();
                    counter++;
                }

            }
            else
            {
                    temp= Head.getNext();
                    while (temp != Head){
                        if (counter==index)
                        {
                            temp.data=object;
                            return;
                        }
                        temp=temp.getNext();
                        counter++;
                    }
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
        Node getNext(){
            return next;
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
