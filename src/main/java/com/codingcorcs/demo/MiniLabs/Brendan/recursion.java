package com.codingcorcs.demo.MiniLabs.Recursion;

class recursion
{static int factorial( int n ) {
    if (n != 0)  // termination condition
        return n * factorial(n-1); // recursive call
    else
        return 1;
}

    public static void main(String[] args) {
        int number = 9, result;
        result = factorial(number);
        System.out.println(number + " factorial = " + result);

    }
}
