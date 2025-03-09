package org.striker25.leetcode75;

import java.util.*;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {

        System.out.println(Objects.requireNonNull(reverseVowels("IceCreAm")).equalsIgnoreCase("AceCreIm")); // true
    }

    public static String reverseVowels(String s) {

        if (s == null){
            return null;
        }

        final String vowels = "aeiou";

        var charArray = s.toCharArray();

        Stack<Map.Entry<Integer, Character>> currentVowelPosition = new Stack<>();
        System.out.println(vowels);

        for (int i = 0; i < s.length(); i++) {

            var currentCharacterStr = String.valueOf(s.charAt(i));

            if (vowels.contains(currentCharacterStr.toLowerCase())){
                currentVowelPosition.add(Map.entry(i, s.charAt(i)));
            }
        }

        for (int i = 0; i < charArray.length; i++) {

            var currentCharacterStr = String.valueOf(charArray[i]);

            if (vowels.contains(currentCharacterStr.toLowerCase())){
                var newValue = currentVowelPosition.pop();
                charArray[i] = newValue.getValue();
            }
        }


        return String.valueOf(charArray);
    }
}
