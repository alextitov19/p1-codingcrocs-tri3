package com.codingcorcs.demo.MiniLabs.Andrew.Recursion;

import java.util.*;

public class Fibo {

    Fibo()
    {

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
        else return findValBad(n-1) + findValBad(n-2); // really bad for optimization o(2^n)
    }
    public int DriverForBetter(int n)
    {
        int[] f = {0,1}; //terms 1 and 2 of sequence
        findVal(n,f);
        return f[0]; //returns the f value to
    }

    /**
     * returns modified array
     * @param n the nth term in the sequence
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
    public List<Long> memoizationDriver(int n)
    {
        List<Long> Sequence = new ArrayList<>(Collections.nCopies(n+1,-1L));
        fibUsingMem(n,Sequence);
        return Sequence;
    }
    /*
     Long[] tempArray = new Long[n+1];
        Arrays.fill(tempArray,-1L);
        List<Long> listOfns = Arrays.asList(tempArray);
        System.out.println(listOfns.toString());
        fibUsingMem(n,listOfns);
        return listOfns;
     */
    private void fibUsingMem(int n,List<Long> array)
    {
        if (n<= 1)
        {
            array.set(n, (long) Math.max(n,0));
            if (n==1)
            {
                array.set(0, 0L);
            }
            return;
        }
        if (array.get(n - 1) == -1) {
            fibUsingMem(n - 1, array);
        }
        long first = array.get(n-1);
        if (array.get(n-2) == -1)
        {
            fibUsingMem(n-2,array);
        }
        long second = array.get(n-2);
        array.set(n,first+second);

    }


    /**
     * tester
     * @param args not used
     * the tester job is just to test all three different methods being dynamic,normal recursion,memorization
     */
    public static void main(String[] args)
    {
        Fibo temp = new Fibo();
        System.out.println(temp.findValBad(20));
        System.out.println(temp.DriverForBetter(20));
        System.out.println(temp.memoizationDriver(60));

    }








}
