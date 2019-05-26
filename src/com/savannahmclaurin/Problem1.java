package com.savannahmclaurin;

public class Problem1 {
    // IF we list all numbers below 10 that are multiples of 3 or 5,
    //  we get 3, 5, 6, and 9. Their sum is 23
    //  Find the sum of multiples of 3 or 5 below 1000
    public static int test_solution(int min, int max){ // static so it can be used with any problem
        int sum = 0;
        for(int i = 0 ; i >= min && i < max ; i++){
            if(i%5 == 0){sum += i;}    // add multiple of 5 to sum
            if((i%3 == 0) && (i % 5 != 0)){sum += i;}     // add multiple of 3 if not multiple of 5
        }
        return sum;
    }

    public static int smaller(int a, int b){
        if(a > b){return b;}
        else{return a;}
    }

    public static int problem1solution_r(int min, int max){ // recursive solution for problem,
        int sum = 0; // set sum to 0                        // min and max are numbers to search between (min inclusive, max exclusive),

        int i = 0; // using i to establish the starting number in our factors of 3 and 5 we iterate through
        if(min >= 0){i = (int)(Math.ceil(min/5.0));
        } else{i = (int)(Math.ceil(min/3.0));}

        int f = 0; // using f to establish the ending number in our factors of 3 and 5 we iterate through
        if(max >= 0){f = (int)(Math.ceil(max/3.0));
        } else{f = (int)(Math.ceil(max/5.0));}

        if(i < f){return problem1solution_rcalc(i, f, min, max, sum);}
        else{return 0;}
    }

    private static int problem1solution_rcalc(int i, int f, int min, int max, int sum){
        //System.out.println("i: " + i + ", f: " + f);
        if(i<f){
            if (i*3 < max && i*3 >= min){sum += i*3;}
            if (i*5 < max && i*5 >= min && (i*5)%3!=0){sum += i*5;}
            return problem1solution_rcalc(i+=1, f, min, max, sum);
        }
        return sum;
    }
}
