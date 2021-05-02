package com.codingcorcs.demo.MiniLabs.Recursion;

public class BHLinkedList {


    BHNode head;
    BHNode tail;




    public void add(String element){


        BHNode newNode = new BHNode(element);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;


    }

    public BHNode get(Integer index) {

        BHNode current = head;

        Integer counter = 0;

        while(counter != index) {

            if (current != null) {
                current = current.getNext();
            }

            counter ++;
        }

        return current;

    }
    public BHNode find(String data) {
        BHNode current = head;

        while(!(current.getData().equals(data)) && current != null) {

            current = current.getNext();
        }

        return current;
    }

    public void insert(BHNode nextToNewNode, BHNode newNode) {
        System.out.println(this.tail.getPrevious());
        System.out.println(nextToNewNode.getPrevious());
        BHNode previousToNewNode = nextToNewNode.getPrevious();


        previousToNewNode.setNext(newNode);
        newNode.setPrevious(previousToNewNode);

        nextToNewNode.setPrevious(newNode);
        newNode.setNext(nextToNewNode);

    }

    public void insertHead(BHNode newNode){

        newNode.setPrevious(this.head.getPrevious());
        newNode.setNext(this.head);
        this.head.setPrevious(newNode);
        head = newNode;
    }

    public void delete(BHNode deleted){


        deleted.getPrevious().setNext(deleted.getNext());

        deleted.getNext().setPrevious(deleted.getPrevious());


    }

    public void deleteTail(){

        tail.getPrevious().setNext(null);

        tail = tail.getPrevious();

    }

    public void deleteHead(){

        head.getNext().setPrevious(null);

        head = head.getNext();
    }


    public BHLinkedList sortList()
    {

        BHNode current = head, index = null;

        String temp;

        if (head == null) {
            return this;
        }
        else {
            while (current != null) {

                index = current.getNext();

                while (index != null) {

                    if (current.getData().length() > index.getData().length()) {
                        temp = current.getData();
                        current.data = index.getData();
                        index.data = temp;
                    }

                    index = index.getNext();
                }
                current = current.getNext();
            }
        }

        return this;
    }



    public String display(BHNode reference){

        if (reference.getNext() == null){
            return reference.getData() + " ]";

        } else{

            return reference.getData() + ", " + display(reference.getNext());
        }
    }


}
