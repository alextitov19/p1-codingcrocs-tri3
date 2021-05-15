package com.codingcorcs.demo.MiniLabs.Recursion;

public class apple {

        public static final boolean clean=true;
        public static final boolean rotten=false;

        private boolean[] apple;

        public apple (boolean[]apple) {
        }
        public static void main (String []args){
            boolean[] b = {clean, rotten, clean, rotten,};
            apple c = new apple (b);

        }
}