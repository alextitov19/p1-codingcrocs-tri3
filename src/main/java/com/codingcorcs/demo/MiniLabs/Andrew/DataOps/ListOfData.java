package com.codingcorcs.demo.MiniLabs.Andrew.DataOps;

import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.Animals;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.People;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ListOfData {

    public static List<MasterDataType> masterDataTypeList(){
        List<MasterDataType>thing = new ArrayList<>();
        thing.add(new People("Kerri","Smith",25,"Teacher","Female",true));
        thing.add(new People("John","Smith",30,"FireFighter","Male",true));
        thing.add(new Animals("lion","yellow",12));
        thing.add(new Animals("fish","green",2));
        thing.add(new Animals("cat","orange",9));
        return thing;

    }
}
