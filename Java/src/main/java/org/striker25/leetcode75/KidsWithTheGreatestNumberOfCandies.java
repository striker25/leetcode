package org.striker25.leetcode75;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    // complexity: O(N)
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Integer> candyList = Arrays.stream(candies).boxed().toList();

        return Arrays.stream(candies)
                .boxed()
                .toList()
                .stream()
                    .max(Integer::compareTo)
                    .map(max ->
                            candyList.stream()
                                    .map(e -> (e + extraCandies) >= max)
                                    .toList()
                    ).orElse(Collections.emptyList());
    }


    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
    }
}
