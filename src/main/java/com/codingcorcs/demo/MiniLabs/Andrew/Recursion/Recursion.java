package com.codingcorcs.demo.MiniLabs.Andrew.Recursion;
import java.util.List;

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
   public List<Long> getFib(int n)
    {
        Fibo fib = new Fibo();
        return fib.memoizationDriver(n);
    }



}
