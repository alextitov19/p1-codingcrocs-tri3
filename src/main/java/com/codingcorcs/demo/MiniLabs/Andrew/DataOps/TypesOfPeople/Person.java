package com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople;

import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.MasterDataType;
import lombok.Getter;

/* can not be instantiated must be extended */
@Getter
public abstract class Person extends MasterDataType {
    public final String type = "Person";
    private String FirstName;
    private String LastName;
    private int Age;



    public Person(String Firstname, String Lastname, int Age)
    {
        this.FirstName=Firstname;
        this.LastName=Lastname;
        this.Age= Age;
    }
    public abstract String toString();

}
