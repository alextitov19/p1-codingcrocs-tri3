package com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal;

import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import static com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.AnimalEnums.*;

public class Animals extends MasterDataType {
    public static AnimalEnums key = Title;
    public String name;
    public String color;
    public int age;

    public Animals(String name, String color, int age)
    {
        super.type = "Animal";
        this.name= name;
        this.color=color;
        this.age = age;
    }


    @Override
    public String toString() {
        switch (key)
        {
            case Age: return String.format("%s , %s", this.age , this.name);
            case color: return String.format("%s , %s", this.color , this.name);
            case Name: return String.format("%s",this.name);
            case Title:
            default: return String.format("%s: %s , %s , %s",super.type,this.name,this.color,this.age);
        }
    }
}
