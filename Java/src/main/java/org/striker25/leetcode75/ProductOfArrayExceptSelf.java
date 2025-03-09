package org.striker25.leetcode75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // current solution O(N)
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // calculate prefixes
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++ ){
            prefix[i] = prefix[i - 1] * nums[i-1];
        }

        int suffix = 1;
        for(int i = n -1; i >=0 ; i--){
            result[i] = prefix[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
    }

    // previous solution O(N^2)
    private int multiplyIntArray(int[] nums){
        return Arrays.stream(nums).reduce(1, (a, b) -> a*b);
    }

    private int[] newArrayWithoutIndex(int[] nums, int index){

        int[] newArray = new int[nums.length - 1];

        for (int i = 0, j=0; i < nums.length; i++) {
            if (i==index){
                continue;
            }

            newArray[j++] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf clazz = new ProductOfArrayExceptSelf();
        var result = clazz.productExceptSelf(new int[]{1, 2, 3, 4});

        System.out.println("result = " + Arrays.toString(result));
    }
}
