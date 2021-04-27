package com.codingcorcs.demo.MiniLabs.Andrew.DataOps;

import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.Animal.AnimalEnums;
import com.codingcorcs.demo.MiniLabs.Andrew.DataOps.TypesOfPeople.PersonAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataOpsDto {
    boolean person;
    boolean Animal;
    AnimalEnums animalEnums;
    PersonAttributes personEnums;

}
