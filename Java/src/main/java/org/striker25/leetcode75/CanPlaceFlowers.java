package org.striker25.leetcode75;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        // if n = 0 and flowerbed.length = 0, skip this loop
        for (int i = 0; n > 0 && flowerbed.length > 1 && i < flowerbed.length; i++) {

            if (flowerbed[i] == 0 && (validateBorders(flowerbed, i) || validateNormalCase(flowerbed, i))) {
                n -= 1;
                flowerbed[i] = 1;
            }
        }

        return n == 0 || isSingleElementArray(flowerbed, n);
    }

    /**
     * validates the case when a single plot is provided, this plot is free and we are required to plant one flower
     * */
    private static boolean isSingleElementArray(int[] flowerbed, int n) {
        return flowerbed.length == 1 && flowerbed[0] == 0 && n == 1;
    }

    /**
    * validates left and right borders checking if their adjacent are planted
    * */
    private static boolean validateBorders(int[] flowerbed, int i) {
        return (i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0);
    }

    /**
     * validates whether the current position if a free spot, and if their adjacent on left and right are free
     * */
    private static boolean validateNormalCase(int[] flowerbed, int i) {
        return (i > 0 && flowerbed[i - 1] == 0) && (i < flowerbed.length - 1 && flowerbed[i + 1] == 0);
    }


    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // expected=false
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));// expected=false
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{0}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0}, 1)); // expected=true
        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0)); // expected=true

    }
}
