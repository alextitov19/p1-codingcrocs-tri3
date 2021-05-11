package com.codingcorcs.demo.MiniLabs.Andrew.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecondaryClass extends MainClass{
    String name;
    public SecondaryClass(int value , String name) {
        super(value);
        this.name = name;
    }

    @Override
    public String toString() {
        return "SecondaryClass{" +
                "name='" + name + '\'' +
                '}';

    }
     // uses default compareTo
}
