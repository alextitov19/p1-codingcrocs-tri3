package com.codingcorcs.demo.MiniLabs.Andrew.Recursion;


/**
 * Class will contain mini lab recursion for Andrew
 */
public class Recursion {
    int doFactoiral(int n)
    {
        if (n>0)
        {
            return n * doFactoiral(--n);
        }
        else return 1;
    }
    int getFib(int n)
    {
        Fibo fib = new Fibo(n);
        return fib.val;
    }



}
