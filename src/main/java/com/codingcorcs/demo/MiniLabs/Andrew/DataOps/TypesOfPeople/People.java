package com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople;

import java.util.Arrays;

import static com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.PersonAttributes.*;

public class People extends Person {

    public static PersonAttributes key = Title;
    public String Occupation;
    private String Gender;
    private boolean Married;

    public People(String firstName, String LastName, int Age,String occupation, String Gender, boolean Married)
    {
        super(firstName,LastName,Age);
        this.Occupation= occupation;
        this.Gender=Gender;
        this.Married = Married;

    }


    @Override
    public String toString() {
                switch (key)
                {
                    case Gender: return String.format("%s , %s , %s",this.Gender , super.getLastName() , super.getFirstName());
                    case Occupation: return String.format("%s , %s , %s",this.Occupation, super.getLastName() , super.getFirstName());
                    case Married: return String.format("%s , %s , %s",this.Married , super.getLastName() , super.getFirstName());
                    case Title:
                    default: return String.format("%s: %s , %s , %s , %s , %s , %s ,",super.getType(),super.getLastName(), super.getFirstName(), super.getAge(), this.Gender, this.Occupation, this.Married);
                }
    }
}
