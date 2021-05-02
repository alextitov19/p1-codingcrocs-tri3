package com.codingcorcs.demo.MiniLabs.Recursion;

public class BHNode {

    public String data;
    public BHNode nextPoint;


    private BHNode previous;
    private BHNode next;

    public BHNode(String input) {

        data = input;
        nextPoint = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String input) {
        this.data = input;
    }



    public BHNode getPrevious() {
        return previous;
    }

    public void setPrevious(BHNode previous) {
        this.previous = previous;
    }

    public BHNode getNext() {
        return next;
    }

    public void setNext(BHNode next) {
        this.next = next;
    }

    @Override
    public String toString() {

        if (this != null){

            return "Node [data=" + data + ", next=" + next + "]";

        } else {

            return "null";
        }
    }
}
