package org.striker25.leetcode75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Objects;

public class GreatestCommonDivisorOfStringsTest {


    @ParameterizedTest
    @CsvSource(value = {
            "ABC,ABCABC,ABC",
            "AB,ABABAB,ABAB",
            ",ABCDEF,ABC",
            "TAUXX,TAUXXTAUXXTAUXXTAUXXTAUXX,TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX",
            "CXTXN,CXTXNCXTXNCXTXNCXTXNCXTXN,CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN",
            ",AAAAAAAAA,AAACCC",
            ",ABABCCABAB,ABAB",
            ",LEET,CODE"
    })
    public void testGcdOfStrings(String expected, String str1, String str2) {

        if (Objects.isNull(expected)) {
            expected = "";
        }

        String actual = GreatestCommonDivisorOfStrings.gcdOfStrings(str1, str2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,0",
            "3,2",
            "5,3",
            "5,4",
            "7,5",
            "7,6"
    })
    public void testGenerateNextPrime(int expected, int input) {

        int actual = GreatestCommonDivisorOfStrings.generateNextPrime(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "18,36|54|90",
            "6,18|24",
    })
    public void testGreatestCommonDivisor(int expected, String input) {

        int[] parameters = Arrays.stream(input.split("\\|")).toList()
                .stream().mapToInt(Integer::parseInt).toArray();

        int actual = GreatestCommonDivisorOfStrings.greatestCommonDivisor(parameters);
        Assertions.assertEquals(expected, actual);
    }

}
