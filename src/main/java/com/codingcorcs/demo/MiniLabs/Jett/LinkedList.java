package com.codingcorcs.demo.MiniLabs.Jett;

import java.util.ArrayList;

public class LinkedList {

    Node head;
    ArrayList<Node> nlist;

    public LinkedList(int[] arr) {
        head = new Node(arr[0]);
        ArrayList<Node> nlist = new ArrayList<Node>();
        nlist.add(head);
        for (int i = 1; i < arr.length; i++) {
            nlist.add(new Node(arr[i]));
        }
        for (int i = 0; i < nlist.size() - 1; i++) {
            nlist.get(i).next = nlist.get(i+1);
        }
    }
    
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
        public Node returnNext() {
            return next;
        }
    }

    public ArrayList<Integer> returnLinkedList() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Node node = head;
        while(node != null) {
            nums.add(node.data);
            node = node.next;
        }
        return nums;
    }

    public String toString() {
        String list = "Original Linked List: [";
        for (int a : returnLinkedList()) {
            list+= (a + ", ");
        }
        list+="]";
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {};
        LinkedList linkedList = new LinkedList(arr);
        System.out.println(linkedList);
    }
}