package org.striker25.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        StringBuilder greatestCommonDivisor = new StringBuilder();

        final int strOneLength = str1.length();
        final int strTwoLength = str2.length();
        final int max = Math.max(strOneLength, strTwoLength);
        final int min = Math.min(strOneLength, strTwoLength);

        // obtain the limit based on the GCD of str lengths
        final int limit = greatestCommonDivisor(min, max);

        // build a candidate divisor string
        for (int i = 0; i < limit; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                greatestCommonDivisor.append(str1.charAt(i));
            } else {
                break;
            }
        }

        String greatestCommonDivisorStr = greatestCommonDivisor.toString();

        // check if divisor can form both strings completely
        if (canFormString(str1, greatestCommonDivisorStr) && canFormString(str2, greatestCommonDivisorStr)) {
            return greatestCommonDivisorStr;
        }

        return "";
    }


    private static boolean canFormString(String original, String divisor) {
        int divisorLength = divisor.length();
        int originalLength = original.length();

        if (divisorLength == 0){
            return false;
        }

        // if the original length is not divisible by the length of the divisor,
        // then it cannot be formed
        if (originalLength % divisorLength != 0) {
            return false;
        }

        // check if the original string can be formed repeating the divisor

        return divisor.repeat(originalLength / divisorLength).equals(original);
    }

    public static int greatestCommonDivisor(int... x) {
        Integer[] parameters = Arrays.stream(x).boxed().toArray(Integer[]::new);

        int primeNumber = generateNextPrime(0);
        List<Integer> commonDivisors = new ArrayList<>();

        do {
            boolean[] isDivisibleArr = new boolean[parameters.length];

            // verify if all elements are divisible by prime number
            boolean isDivisible = isDivisible(parameters, primeNumber, isDivisibleArr);

            // reduce rows since all of them are divisible
            if (isDivisible) {
                commonDivisors.add(primeNumber);
                divideArrayByPrimeNumber(parameters, primeNumber);

            } else {
                primeNumber = generateNextPrime(primeNumber);
            }

            // check if current rows element are less than current prime
        } while (!verifyIfDivisionIsPossible(parameters, primeNumber));

        return commonDivisors.stream().reduce(1, (a, b) -> a * b);
    }

    private static boolean isDivisible(Integer[] parameters, int primeNumber, boolean[] isDivisibleArr) {
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] % primeNumber == 0) {
                isDivisibleArr[i] = true;
            }
        }

        Boolean[] isDivisibleArrayWrapper = new Boolean[isDivisibleArr.length];
        for (int i = 0; i < isDivisibleArr.length; i++) {
            isDivisibleArrayWrapper[i] = isDivisibleArr[i];
        }

        return Arrays.stream(isDivisibleArrayWrapper).allMatch(Boolean::valueOf);
    }

    private static void divideArrayByPrimeNumber(Integer[] parameters, int primeNumber) {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = parameters[i] / primeNumber;
        }
    }

    private static boolean verifyIfDivisionIsPossible(Integer[] parameters, int primeNumber) {
        List<Integer> currentNumbers = Arrays.stream(parameters).toList();
        Optional<Integer> minValueOpt = currentNumbers.stream().min(Integer::compare);

        if (minValueOpt.isPresent()) {
            int min = minValueOpt.get();

            // stop execution here, no more division is posible
            return min < primeNumber;
        }

        return false;
    }

    public static int generateNextPrime(int currentPrime) {
        if (currentPrime < 2) {
            return 2;
        }

        int counter = currentPrime + 1;

        while (true) {
            if (isPrime(counter)) {
                return counter;
            }

            counter++;
        }

    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }


}
