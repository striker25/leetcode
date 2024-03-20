package com.striker25.sorting.bubblesort;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

  /*
   * Complete the 'countSwaps' function below.
   *
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static void countSwaps(List<Integer> a) {
    // Write your code here

    // https://www.hackerrank.com/challenges/ctci-bubble-sort/problem

    // convert list to array
    int[] numbers = a.stream().mapToInt(Integer::intValue).toArray();
    int countSwaps = 0;

    // bubble sort, outer loop is the number of passes
    for (int i = 0; i < numbers.length; i++) {

      // inner loop is the number of comparisons n-1
      for (int j = 0; j < numbers.length - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          // auxiliary variable is needed to swap
          int aux = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = aux;
          countSwaps++;
        }
      }
    }

    System.out.println(String.format("Array is sorted in %s swaps.", countSwaps));
    System.out.println(String.format("First Element: %s", numbers[0]));
    System.out.println(String.format("Last Element: %s", numbers[numbers.length - 1]));
  }


}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.countSwaps(a);

    bufferedReader.close();
  }
}

