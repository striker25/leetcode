package org.striker25.leetcode75;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        final int word1Length = word1.length();
        final int word2Length = word2.length();

        StringBuilder mergedString = new StringBuilder();
        for(int i=0; i < Math.max(word1Length, word2Length); i++){
            if (word1Length > i){
                mergedString.append(word1.charAt(i));
            }

            if (word2Length > i){
                mergedString.append(word2.charAt(i));
            }
        }

        return mergedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }
}
