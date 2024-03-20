package com.striker25.sorting.insertionsort1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here

    int[] numbers = arr.stream().mapToInt(Integer::intValue).toArray();
    int lastNum = numbers[n - 1];


    try {
      for (int i = n - 1; i >= 0; i--) {
        // already on first element or current is less than or equal to last
        // then no need to shift and just place the last number
        if (i == 0 || numbers[i - 1] <= lastNum) {
          numbers[i] = lastNum;
          break;
        }

        // shift right
        numbers[i] = numbers[i - 1];

        printArray(numbers);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    printArray(numbers);
  }

  private static void printArray(int[] array) {
    System.out.println(Arrays.toString(array)
        .replace("[", "")
        .replace("]", "")
        .replace(",", "")
    );
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {

    Result.insertionSort1(5, Arrays.asList(2, 4, 6, 8, 3));
    Result.insertionSort1(14, Arrays.asList(1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23));
    Result.insertionSort1(10, Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1));
  }
}


