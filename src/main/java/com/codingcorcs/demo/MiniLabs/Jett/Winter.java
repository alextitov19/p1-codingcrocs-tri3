package com.codingcorcs.demo.MiniLabs.Jett;

public class Winter extends Summer {
    private String athlete;
    public Winter(String t, String a, String i) {
        super(t, a);
        athlete = i;
    }
    public String toString() {
        return super.toString() + " Performer: " + athlete;
    }
}
