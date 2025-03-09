package org.striker25.leetcode75;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        StringBuilder reversedWords = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]).append(" ");
        }

        return reversedWords.toString().trim();
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue").equals("blue is sky the")); // true
        System.out.println(reverseWords("  hello world  ").equals("world hello")); // true
        System.out.println(reverseWords("a good   example").equals("example good a")); // true
    }
}
