package com.codingcorcs.demo;
import java.util.ArrayList;
import java.util.Arrays;

import com.codingcorcs.demo.MiniLabs.Jett.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/miniLab/Jett"})
public class JettMiniLabController {

    private static int[] linkedArray = {4, 8, 3, 2, 5};

    public ArrayList<Integer> toArrayList(int[] arr) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int a : arr) {
            nums.add(a);
        }
        return nums;
    }

    public int[] toArray(ArrayList<Integer> arr) {
        int[] array = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }
        return array;
    }

    @GetMapping("")
    public String HtmlTemplate(@RequestParam(value = "word", required = false) String word, Model model)
    {
        if(word != null){
            boolean isPal = PalindromeCheck.isPal(word);

            model.addAttribute("isPal",  isPal);
        }
        return "Jett/JettPalindrome";
    }

    @GetMapping("/insertion")
    public String insertion(@RequestParam(value="length", required = false, defaultValue = "8") int length, @RequestParam(value="array", required = false, defaultValue = "[\"Water\", \"Box\", \"Phone\", \"Bottle\", \"After\"]") String array, Model model) {
        long startTime = System.nanoTime();
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            array1.add((int)(Math.random()*100+1));
        }
        model.addAttribute("unsorted", "Unsorted: " + array1.toString());
        //Integer[] arr = (Integer[]) array.toArray();
        Integer[] arr = new Integer[length];
        for (int j = 0; j < length; j++) {
            arr[j] = array1.get(j);
        }
        InsertionRecursion insertion = new InsertionRecursion();
        model.addAttribute("sorted", "Sorted: " + insertion.characterSort(arr));
        long finalTime = System.nanoTime() - startTime;
        model.addAttribute("time", "It took " + finalTime + " nanoseconds to calculate");

        long startTime1 = System.nanoTime();
        String[] unsorted = array.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        model.addAttribute("notsorted", "Unsorted: " + array);
        InsertionRecursion stringInsertion = new InsertionRecursion();
        model.addAttribute("sorted2", "Sorted: " + stringInsertion.characterSort(unsorted));
        long finalTime1 = System.nanoTime() - startTime1;
        model.addAttribute("time1", "It took: " + finalTime1 + " nanoseconds to calculate");


        Summer summer = new Summer("200 Meter Freestyle", "Swimming");
        Summer summer2 = new Summer("100 Meter Dash", "Sprinting");
        Summer summer3 = new Winter("Half Pipe", "Snowboarding", "Shaun White");
        Summer[] sports = {summer, summer2, summer3};

        model.addAttribute("sportunsorted", "Unsorted: " + Arrays.toString(sports));
        InsertionRecursion sportInsertion = new InsertionRecursion();
        model.addAttribute("sportsorted", "Sorted: " + Arrays.toString(sportInsertion.sort(sports)));


        return "Jett/JettInsertion.html";
    }

    @GetMapping("/inheritance")
    public String inheritance(@RequestParam(value = "catSpots", required = false) Integer catSpots,  @RequestParam(value = "catStripes", required = false) Integer catStripes, @RequestParam(value = "dogBrown", required = false) Integer dogBrown, @RequestParam(value = "dogWhite", required = false) Integer dogWhite, Model model){

        int catSpotsNum = (catSpots == null || catSpots<0 || catSpots>10)?0:catSpots.intValue();
        int catStripesNum = (catStripes == null || catStripes<0 || catStripes>10)?0:catStripes.intValue();
        int dogBrownNum = (dogBrown == null || dogBrown<0 || dogBrown>10)?0:dogBrown.intValue();
        int dogWhiteNum = (dogWhite == null || dogWhite<0 || dogWhite>10)?0:dogWhite.intValue();

        ArrayList<Inheritance.Animal> animalList = new ArrayList<>();
        for(int i=0;i<catSpotsNum;i++){ animalList.add(new Inheritance.Cat("Spots")); }
        for(int i=0;i<catStripesNum;i++){ animalList.add(new Inheritance.Cat("Stripes")); }
        for(int i=0;i<dogBrownNum;i++){ animalList.add(new Inheritance.Terrier("Brown")); }
        for(int i=0;i<dogWhiteNum;i++){ animalList.add(new Inheritance.Terrier("White")); }


        String[] strings = new String[animalList.size()];
        Integer[]pnds = new Integer[animalList.size()];
        int totalPnds = 0;

        for(int i=0;i<strings.length;i++){
            strings[i] = animalList.get(i).toString();
            pnds[i] = animalList.get(i).getLbs();
            totalPnds +=pnds[i];
        }

        model.addAttribute("strings", strings);
        model.addAttribute("cals",pnds);
        model.addAttribute("totalPnds", totalPnds);

        model.addAttribute("catSpots", catSpotsNum);
        model.addAttribute("catStripes", catStripesNum);
        model.addAttribute("dogBrown", dogBrownNum);
        model.addAttribute("dogWhite", dogWhiteNum);


        return "Jett/JettInheritance.html";
    }

    @GetMapping("/newlinkedlist")
    public String linkedList(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2, @RequestParam(value = "num3", required = false) Integer num3, @RequestParam(value = "headremove", required = false, defaultValue = "no") String headremove, @RequestParam(value = "tailremove", required = false, defaultValue = "no") String tailremove, @RequestParam(value = "midremove", required = false, defaultValue = "no") String midremove, Model model) {
        ArrayList<Integer> numbers = toArrayList(linkedArray);
        if (num1 != null) {
            numbers.add(0, num1);
        }
        if (num2 != null) {
            numbers.add(num2);
        }
        if (num3 != null) {
            numbers.add(numbers.size() / 2, num3);
        }
        if (headremove.equals("1")) {
            numbers.remove(0);
        }
        if (tailremove.equals("1")) {
            numbers.remove(numbers.size() - 1);
        }
        if (midremove.equals("1")) {
            numbers.remove(numbers.size() / 2);
        }
        linkedArray = toArray(numbers);
        LinkedList list = new LinkedList(linkedArray);
        model.addAttribute("list", list);
        return "Jett/JettNewLinkedList.html";
    }

}
