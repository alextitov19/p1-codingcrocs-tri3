package com.codingcorcs.demo.Andrew;

import com.codingcorcs.demo.Andrew.ArrayList.MyArrayList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.DoubleCircleLinkedList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.LinkedListInterFace;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.SingleLinkedList;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.AnimalEnums;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.Animals;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.DataOpsDto;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.ListOfData;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.People;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.PersonAttributes;
import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Recursion;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.BubbleSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.InsertionSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.SelctionSort;
import com.codingcorcs.demo.MiniLabs.Andrew.Sorting.Sorts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public String DataOpsMapping(Model model, @ModelAttribute DataOpsDto dto)
    {
        if (dto.getAnimalEnums()==null || dto.getPersonEnums()==null){
            dto = new DataOpsDto();
            dto.setAnimalEnums(AnimalEnums.Title);
            dto.setAnimal(true);
            dto.setPerson(true);
            dto.setPersonEnums(PersonAttributes.Title);
        }
      /* System.out.println(dto.isAnimal());
        System.out.println(dto.isPerson());
        System.out.println(dto.getPersonEnums()); // debug */
        LinkedListInterFace<MasterDataType> masterData = new DoubleCircleLinkedList<>();
        if (dto.isAnimal())masterData.addAll(ListOfData.animalList());
        if (dto.isPerson())masterData.addAll(ListOfData.peopleList());
        Animals.key=dto.getAnimalEnums();
        People.key=dto.getPersonEnums();
      /*for (MasterDataType type : masterData) { //testing java syntax
            System.out.println(type);
        }*/
        if (masterData.getSize()==0){
            model.addAttribute("ListData", new ArrayList<>(Collections.singleton("empty")));
            model.addAttribute("Dto", new DataOpsDto());
            return "Andrew/DataOps";
        }else
            masterData.sort();
            model.addAttribute("ListData",masterData);
            model.addAttribute("Dto", new DataOpsDto());
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

    @GetMapping("/Lists")
    public String listMapping(Model model,@RequestParam(value = "CreateField",required = false,defaultValue = "12 15 16 17 18 19 152 167")String listOfData , @RequestParam(value = "Index", required = false) Integer index,@RequestParam(value = "Append",required = false) Integer value, @RequestParam(value = "Sort",required = false, defaultValue = "false") boolean Sort
    ,@RequestParam(value = "DeleteIndex", required = false)Integer DeleteIndex){
        String[] array = listOfData.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();
        for (String data:array) {
            try{
                Integer temp = Integer.parseInt(data);
                integers.add(temp);
            }catch (NumberFormatException e){
                integers.add((int) (Math.random()*25+15));
            }
        }
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(integers);
        LinkedListInterFace<Integer> integerLinkedListInterFace = new SingleLinkedList<>(integers);
        if (value !=null && index != null){
            try {
                integerMyArrayList.add(value,index);
                integerLinkedListInterFace.add(index,value);
            }
            catch (IndexOutOfBoundsException e){
                index = index>= integerMyArrayList.size()? integerMyArrayList.size()-1: 0;
                integerLinkedListInterFace.add(index,value);
                integerMyArrayList.add(value,index);
            }

        }
        if (Sort){
            integerMyArrayList.sort(Integer::compareTo);
            integerLinkedListInterFace.sort(Integer::compareTo);
        }
        if (DeleteIndex!=null){
            try{
                integerMyArrayList.delete(DeleteIndex);
                integerLinkedListInterFace.delete(DeleteIndex);
            }catch (IndexOutOfBoundsException exception){
                DeleteIndex = integerMyArrayList.size()-1;
                integerMyArrayList.delete(DeleteIndex);
                integerLinkedListInterFace.delete(DeleteIndex);
            }
        }
        model.addAttribute("ArrayList", integerMyArrayList);
        model.addAttribute("LinkedList",integerLinkedListInterFace);
        return "Andrew/Lists";
    }

    @GetMapping("/Lists/BenchMark")
    @ResponseBody
    public String BenchMark() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
       return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ListsTester().deltas);
    }


}
