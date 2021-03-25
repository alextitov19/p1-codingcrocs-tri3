package com.codingcorcs.demo.MiniLabs.Andrew.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
    List<Integer> series;
    int n; //nth term in fibo sequence
    int val;
    Fibo(int n)
    {
        series = new ArrayList<>();
        this.n = n;
        this.val = findValBad(n);
    }

    /**
     * less efficient then the array method
     * @param n the term of the sequence the use wants to find
     * @return int value of the nth term
     */
    public int findValBad(int n)
    {
        if (n<=1)
        {
            return Math.max(n, 0);
        }
        else return findValBad(n-1) + findValBad(n-2);
    }
    public int DriverForBetter(int n)
    {
        int[] f = {0,1}; //terms 1 and 2 of sequence
        findVal(n,f);
        return f[0]; //returns the f value to
    }

    /**
     * returns modified array
     * @param n
     * @param f the array pointer
     */
    private void findVal(int n, int[] f)
    {
        if (n == 0) return;
        int temp = f[0];
        f[0]=f[1];
        f[1]=temp+f[1];
        findVal(--n,f);//pass f to the next loop
    }

    /**
     * tester
     * @param args
     */
    public static void main(String[] args)
    {
        Fibo temp = new Fibo(20);
        System.out.println(temp.val);
        System.out.println(temp.DriverForBetter(20));

    }








}
