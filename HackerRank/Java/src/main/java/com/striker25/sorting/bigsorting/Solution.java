package com.striker25.sorting.bigsorting;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here

    // https://www.hackerrank.com/challenges/big-sorting/problem

    unsorted.sort((a, b) -> {
      if (a.length() == b.length()) {
        return new BigInteger(a).compareTo(new BigInteger(b));
      } else {
        return a.length() - b.length();
      }
    });

    return unsorted;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    List<String> result = Result.bigSorting(unsorted);

    bufferedWriter.write(
        result.stream()
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}