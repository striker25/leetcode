package com.striker25.bignumber.javaprimalitytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Type your number to test and hit enter: ");
        String n = bufferedReader.readLine();

        System.out.println(isProbablePrime(n) ? "prime" : "not prime");

        bufferedReader.close();
    }

    public static boolean isProbablePrime(String numStr){
        final var num = new BigInteger(numStr);

        return num.isProbablePrime(100);
    }
}
