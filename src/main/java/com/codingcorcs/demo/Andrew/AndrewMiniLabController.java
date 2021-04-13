package com.codingcorcs.demo.Andrew;

import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.DoubleCircleLinkedList;
import com.codingcorcs.demo.Andrew.DataStructure.LinkedList.LinkedListInterFace;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.ListOfData;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import com.codingcorcs.demo.MiniLabs.Andrew.Recursion.Recursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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



}
