package com.striker25.sorting.insertionsort2;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Result {

  /*
   * Complete the 'insertionSort2' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here

    int[] numbers = arr.stream().mapToInt(Integer::intValue).toArray();


    try {

      for (int i=0; i < n - 1; i++) {

        // if first element is 1 then no need to shift
        if (i==0 && numbers[i] == 1){
          continue;
        }

        if (numbers[i+1] > numbers[i]) {
          printArray(numbers);
          continue;
        }

        // check against previous elements
        for (int j=i; j >= 0; j--) {
          if (numbers[j] > numbers[j+1]) {
            int temp = numbers[j];
            numbers[j] = numbers[j+1];
            numbers[j+1] = temp;
            printArray(numbers);
          }
        }

      }


    } catch (Exception e) {
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

    Result.insertionSort2(6, Arrays.asList(1, 4, 3, 5, 6, 2));
  }
}

