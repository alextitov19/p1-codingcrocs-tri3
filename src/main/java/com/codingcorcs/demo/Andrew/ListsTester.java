package com.codingcorcs.demo.Andrew;

import com.codingcorcs.demo.Andrew.ArrayList.MyArrayList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.DoubleCircleLinkedList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.LinkedListInterFace;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.SingleLinkedList;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class ListsTester {
    LinkedListInterFace<Integer> LinkedListDoubleTester = new DoubleCircleLinkedList<>();
    LinkedListInterFace<Integer> linkedListTester = new SingleLinkedList<>();
    MyArrayList<Integer> myArrayList = new MyArrayList<>();
    HashMap<String,Long> deltas = new HashMap<>();

    public ListsTester(){
        long time = System.nanoTime();
        linkedListTester.addAll(new Random().ints(2500).boxed().collect(Collectors.toList()));
        Long deltaLinked = System.nanoTime()-time;
        deltas.put("LinkedListCreateTimeSingle",deltaLinked);
        time= System.nanoTime();
        myArrayList.addAll(new Random().ints(2500).boxed().collect(Collectors.toList()));
        Long deltaArrayCreate = System.nanoTime()-time;
        deltas.put("ArrayListCreateTime",deltaArrayCreate);
        time= System.nanoTime();
        LinkedListDoubleTester.addAll(new Random().ints(2500).boxed().collect(Collectors.toList()));
        deltas.put("DoubleLinkedListCreateTime",System.nanoTime()-time);
        time= System.nanoTime();
        linkedListTester.add(1524);
        Long deltaInsertLinked = System.nanoTime() - time;
        deltas.put("InsertAtTailLinkedSingle",deltaInsertLinked);
        time=System.nanoTime();
        linkedListTester.add(0,1240);
        deltas.put("InsertAtHeadLinkedSingle",System.nanoTime()-time);
        int indexCalc = LinkedListDoubleTester.getSize()/2 -1;
        time=System.nanoTime();
        linkedListTester.add(indexCalc,1245);
        deltas.put("InsertAtMidLinkedSingle",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.add(1524);
        deltas.put("InsertAtTailDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.add(0,1240);
        deltas.put("InsertAtHeadDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.add(indexCalc,1245);
        deltas.put("InsertAtMidDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.add(1524);
        deltas.put("InsertAtLastIndex",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.add(0,1240);
        deltas.put("InsertAtFirstIndex",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.add(1524,indexCalc);
        deltas.put("InsertAtMidIndex",System.nanoTime()-time);
        time=System.nanoTime();
        linkedListTester.remove();
        deltas.put("TailRemoveSingleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        linkedListTester.remove(indexCalc);
        deltas.put("MidPointRemovedSingleLink",System.nanoTime()-time);
        time=System.nanoTime();
        linkedListTester.remove(0);
        deltas.put("HeadPointRemovedSingleLink",System.nanoTime()-time);
        time=System.nanoTime();
        linkedListTester.sort(Integer::compareTo);
        deltas.put("SortSingleLinkedList",System.nanoTime()-time);
        time=System.nanoTime();
        linkedListTester.clear();
        deltas.put("ClearSingleLinkList",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.remove();
        deltas.put("TailRemovedDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.remove(indexCalc);
        deltas.put("MidPointRemovedDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.remove(0);
        deltas.put("HeadRemovedDoubleLinkedList",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.sort(Integer::compareTo);
        deltas.put("SortDoubleLinkedList",System.nanoTime()-time);
        time=System.nanoTime();
        LinkedListDoubleTester.clear();
        deltas.put("ClearDoubleLinked",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.delete();
        deltas.put("RemoveLastIndex",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.delete(indexCalc);
        deltas.put("RemoveMidPointIndex",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.delete(0);
        deltas.put("RemovedFirstIndex",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.sort(Integer::compareTo);
        deltas.put("SortArrayList",System.nanoTime()-time);
        time=System.nanoTime();
        myArrayList.clear();
        deltas.put("ArrayListClear",System.nanoTime()-time);
    }

    public static void main(String[] args) {
        System.out.println(  new ListsTester().deltas.toString());
    }
}
