package com.codingcorcs.demo.Andrew;

import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.DoubleCircleLinkedList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.LinkedListInterFace;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.SingleLinkedList;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.ListOfData;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Recursion;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.BubbleSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.InsertionSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.SelctionSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.Sorts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping({"/miniLab/Andrew","/minilab/Andrew"})
public class AndrewMiniLabController {
    @GetMapping({"/Fib/{nth}","/Fib/"})
    //@ResponseBody // restfull return
    public String Tester(@PathVariable Optional<Integer> nth , Model model)
    {
        model.addAttribute("ListNth",new Recursion().getFib(nth.orElse(0)));
        return "Andrew/AndrewFib";
    } // used to return json list
    @GetMapping("")
    public String HtmlTemplate()
    {
        return "Andrew/ListOfLabs";
    }
    @GetMapping("/DataOps")
    public String DataOpsMapping(Model model)
    {
        LinkedListInterFace<MasterDataType> masterData = new DoubleCircleLinkedList<>(ListOfData.masterDataTypeList());
      /*for (MasterDataType type : masterData) { //testing java syntax
            System.out.println(type);
        }*/
        model.addAttribute("ListData",masterData);
        return "Andrew/DataOps";
    }
    @GetMapping("/Sorting")
    public String Sorting(Model model){
        long nanoToMill = 1000000;
        int[] selectionSort = new Random().ints(10, 0 , 25).toArray();
        int[] bubbleSort = new Random().ints(10,0,25).toArray();
        int[] insertionSort = new Random().ints(10,0,25).toArray();
        model.addAttribute("selectionPre",selectionSort.clone());
        model.addAttribute("bubbleSort",bubbleSort.clone());
        model.addAttribute("insertionSort",insertionSort.clone());
        Sorts thing = new BubbleSort();
        long time = System.nanoTime();
        thing.sort(bubbleSort);
        float totalTimeBubble = System.nanoTime() - time;
        thing= new SelctionSort();
        time= System.nanoTime();
        thing.sort(selectionSort);
        float totalTimeSelectionSort = System.nanoTime() - time;
        thing = new InsertionSort();
        time = System.nanoTime();
        thing.sort(insertionSort);
        float totalTimeInsertionSort = System.nanoTime()-time;
        model.addAttribute("SelectionSorted", selectionSort);
        model.addAttribute("SelectionTime",totalTimeSelectionSort/nanoToMill);
        model.addAttribute("BubbleSorted", bubbleSort);
        model.addAttribute("BubbleTime", totalTimeBubble/nanoToMill);
        model.addAttribute("InsertionSorted", insertionSort);
        model.addAttribute("InsertionTime",totalTimeInsertionSort/nanoToMill);





        return "Andrew/Sorting";

    }



}
