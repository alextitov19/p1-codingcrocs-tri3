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
        if (index>=getSize()|| index<0){
            throw new IndexOutOfBoundsException("index given is either bigger than LinkList size or is less than 0");
        }
        if (index ==0)
        {
            Head.prev= new Node(object,Tail,Head);
            Head = Head.getPrev();
            size++;
            return;
        }
        if (index == getSize()-1)
        {
            Tail.setNext(new Node(object,Tail,Head));
            Tail = Tail.getNext();
            size++;
            return;
        }
        int counter = 1;
        Node nodeOfIndex;
        if (index>(getSize()-1)-index) {
            nodeOfIndex = Tail.getPrev();
            while((getSize()-1)-counter!=index) {
                nodeOfIndex = nodeOfIndex.getPrev();
                counter++;
            }
            /*Node temp2 = temp.getPrev(); // broken into multiple lines
            temp2.next = new Node(object,temp2,temp);*/

        }
        else{
            nodeOfIndex = Head.getNext();
            while (counter!=index){
                nodeOfIndex = nodeOfIndex.getNext();
                counter++;
            }

        }
            nodeOfIndex.getPrev().setNext(new Node(object,nodeOfIndex.getPrev(),nodeOfIndex));
            nodeOfIndex.setPrev(nodeOfIndex.getPrev().next);
        /*Node prev = nodeOfIndex.getPrev();
        Node newNode = new Node(object,prev,nodeOfIndex);
        prev.next=newNode;
        nodeOfIndex.prev=newNode;*/
        size++;

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
                this.data=data;
                this.prev=prev;
                this.next=next;
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

    public static void main(String[] args) {
        Integer[] thing = {10,12,13,14,15,25,26,27,9,10};
        LinkedListInterFace<Integer> linkedListInterFace = new DoubleCircleLinkedList<>(thing);
        linkedListInterFace.add(14);
        linkedListInterFace.add(4,23);
        linkedListInterFace.set(4,92);
        System.out.println("thing");
    }
}
