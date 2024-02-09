package com.striker25.advanced.javasha256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Type your string to hash into SHA256: ");
        String password = bufferedReader.readLine();
        bufferedReader.close();

        MessageDigest md = MessageDigest.getInstance("SHA256");
        byte[] sha256 = md.digest(password.getBytes());
        String output = String.format("%064X", new BigInteger(1, sha256));

        System.out.println(output.toLowerCase());

    }
}
