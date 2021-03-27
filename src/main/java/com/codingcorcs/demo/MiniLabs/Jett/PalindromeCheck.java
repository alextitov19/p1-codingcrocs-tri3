package com.codingcorcs.demo.MiniLabs.Jett;

class PalindromeCheck
{
//string 0 or 1 means that it is a palindrome
    public static boolean isPal(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
           //Recursion
            return isPal(s.substring(1, s.length()-1));

        return false;
    }

    public static void main(String[]args)
    {
        String s = "racecar";
        if(isPal(s))
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");
        String p = "apples";

        if(isPal(p))
            System.out.println(p + " is a palindrome");
        else
            System.out.println(p + " is not a palindrome");
    }
}