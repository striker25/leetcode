package org.striker25.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {

        // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765

        int n = 30;
        List<Long> fibOne = fiboOne(n);

        System.out.println(fibOne);
    }

    public static List<Long> fiboOne(int n){
        List<Long> fib = new ArrayList<>(List.of(0L, 1L));
        for (int i =0; i< n; i++){
            long a = fib.get(fib.size() -2);
            long b = fib.get(fib.size()-1);
            fib.add((a + b));
        }

        return fib;
    }


}
