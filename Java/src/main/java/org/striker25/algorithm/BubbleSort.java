package org.striker25.algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = { 5, 4, 3, 2, 1 };
        int i, j, temp, n = arr.length;


        for (i = 0; i < n -1; i++) {
            for (j=0; j < n - i - 1; j++){

                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
