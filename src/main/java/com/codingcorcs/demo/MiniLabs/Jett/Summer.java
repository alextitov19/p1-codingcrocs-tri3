package com.codingcorcs.demo.MiniLabs.Jett;

public class Summer {
    private String heading;
    private String sport;

    public Summer(String t, String a) {
        heading = t;
        sport = a;
    }

    public String getHeading() {
        return heading;
    }

    public String toString() {
        return "Olympic Event: " + heading + ", Sport: " + sport;
    }
}
