package com.codingcorcs.demo.MiniLabs.Andrew.BinarySearch;

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
}
