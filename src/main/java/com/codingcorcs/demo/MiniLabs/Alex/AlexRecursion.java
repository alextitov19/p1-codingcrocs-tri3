package com.codingcorcs.demo.MiniLabs.Alex;

import java.util.concurrent.TimeUnit;

public class AlexRecursion {

    public static void main(String[] args) throws InterruptedException {
        String[] array = {
                " __         __      ",
                "/  \\.-\"\"\"-./  \\",
                "\\    -   -    /    ",
                " |   o   o   |    ",
                " \\  .-'''-.  /   ",
                "  '-\\__Y__/-'    ",
                "     `---`        "
        };
        displayWithTimer(array, 1);
    }

    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static void displayWithTimer(String[] array, int delay) throws InterruptedException {
        TimeUnit.SECONDS.sleep(delay);
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i].length() == 0) {
                return;
            }
            newArray[i] = array[i].substring(1);
        }
        displayWithTimer(newArray, delay);
    }
}
