package com.codingcorcs.demo.Andrew.DataStructure.LinkedList;

import java.util.ArrayList;
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
        indexCheck(index);
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
        indexCheck(index);
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
        }
        else{
            nodeOfIndex = Head.getNext();
            while (counter!=index){
                nodeOfIndex = nodeOfIndex.getNext();
                counter++;
            }

        }
         /*Node temp2 = temp.getPrev(); // broken into multiple lines
            temp2.next = new Node(object,temp2,temp);
            temp.prev = temp2.next
            Better Notation of vars:
                Node prev = nodeOfIndex.getPrev();
                Node newNode = new Node(object,prev,nodeOfIndex);
                prev.next=newNode;
                nodeOfIndex.prev=newNode;*/
            nodeOfIndex.getPrev().setNext(new Node(object,nodeOfIndex.getPrev(),nodeOfIndex));
            nodeOfIndex.setPrev(nodeOfIndex.getPrev().next);
        size++;

    }
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        Node indexer = Head;
        if (indexer == null){
            return builder.append("]").toString();
        }
        do {
            builder.append("(").append(indexer.getData().toString()).append(")");
            indexer =indexer.getNext();
            if (indexer!=Head){
                builder.append(",");
            }
        }while (indexer!=Head && indexer!=null);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override

    public void clear() {
        while(Tail!=Head){
            delete();
        }
        Tail=null;
        Head=null;
        size--;
    }

    @Override
    public void delete(int index) {
        indexCheck(index);
        if (index == 0) {
            Head=Head.getNext();
            Head.setPrev(Tail);
            Tail.setNext(Head);
            size--;
            return;
        }
        if (index == getSize()-1){
                Tail=Tail.getPrev();
                Tail.setNext(Head);
                Head.setPrev(Tail);
        }
        int counter =1;Node NodeOfIndex;
        if (index>(getSize()-1)-index){ //iterate backwards
            NodeOfIndex = Tail.getPrev();
            while ((getSize()-1)-counter!=index){
                NodeOfIndex=NodeOfIndex.getPrev();
                counter++;
            }
        }else{
            NodeOfIndex = Head.getNext();
            while (counter!=index){
                NodeOfIndex = NodeOfIndex.getNext();
                counter++;
            }
        }
            NodeOfIndex.getPrev().setNext(NodeOfIndex.getNext());
            NodeOfIndex.getNext().setPrev(NodeOfIndex.getPrev());
            size--;
    }

    @Override
    public void delete() {
        Tail.prev.setNext(Head);
        Tail = Tail.getPrev();
        Head.setPrev(Tail);
        size--;

    }

    /**
     * inner/inline class of Double Circle list
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

    /**
     * <p color='red'>removes the last item from list but returns it, similar to delete</p>
     * @return the value of the last Item Of list
     * @see #delete(int)
     * @see LinkedListInterFace#remove() InterFace Method Decloration
     */
    @Override
    public t remove() {
        Tail.getPrev().setNext(Head);
        Head.setPrev(Tail.getPrev());
        t temp = Tail.getData();
        Tail = Head.getPrev();
        size--;
        return temp;
    }
    public t peek(){
        return Tail.getData();
    }

    /**
     *
     * @param index the index to be deleted and returned
     * @return value of the specified index
     * @see #delete(int)
     * @see LinkedListInterFace#remove(int) InterFace Method Decloration
     */
    @Override
    public t remove(int index){
        indexCheck(index);
        if (index==0){
            Head.getNext().setPrev(Tail);
            Tail.setNext(Head.getNext());
            t temp= Head.getData();
            Head=Tail.getNext();
            size--;
            return temp;
        }
        if (index==getSize()-1) return remove();
        int counter =1;
        Node indexer;
        if (index>(getSize()-1)-index){
            indexer = Tail.getPrev();
            while(getSize()-1-counter!=index){
                indexer=indexer.getPrev();
                counter++;
            }
        }else{
                indexer=Head.getNext();
                while (counter!=index){
                    indexer = indexer.getNext();
                    counter++;
                }
        }
            indexer.getPrev().setNext(indexer.getNext());
            indexer.getNext().setPrev(indexer.getPrev());
            size--;
            return indexer.getData();

    }

    private void indexCheck(int index){
        if (index>=getSize() || index<0){
            throw new IndexOutOfBoundsException(index+" does not fit given parameters <= size or >= 0");
        }
    }


    public static void main(String[] args) {
        Integer[] thing = {10,12,13,14,15,25,26,27,9,10};
        LinkedListInterFace<Integer> linkedListInterFace = new DoubleCircleLinkedList<>(thing);
        linkedListInterFace.add(14);
        linkedListInterFace.add(4,23);
        linkedListInterFace.set(4,92);
        System.out.println(linkedListInterFace);
        System.out.println();
        linkedListInterFace.clear();
        System.out.println(linkedListInterFace);

    }
}
