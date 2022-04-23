package com.netcracker.edu.odessa;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
/*
Given N ranges of the form [L, R], the task is to find the sum of
all integers that lie in ANY of the given ranges. Important, if some element exists
in more than one range, you should count this element only once(see example below).

Example:
For array {[3, 7], [2, 5]}  the expected output should be 27
Explanation: The set of integers that exist in one or more ranges is
{2, 3, 4, 5, 6, 7}. Here {3, 4, 5} exists in both ranges, so we added only once.
Hence, the sum is 27

{[3, 7], [2, 5], [5,9],[6,20]}
*/

        int[] arr1 = {3, 4, 5, 6, 7};
        int[] arr2 = {2, 3, 4, 5};
        int[] arr3 = {5, 6, 7, 8, 9};
        int[] arr4 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        uniqueValuesCombiner(arr1, arr2, arr3, arr4);
    }

    static void uniqueValuesCombiner(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {

        System.out.println("Given ranges: \n" + Arrays.toString(arr1) +
                Arrays.toString(arr2) +
                Arrays.toString(arr3) +
                Arrays.toString(arr4));

        int arr1L = arr1.length;
        int arr2L = arr2.length;
        int arr3L = arr3.length;
        int arr4L = arr4.length;
        int[] combinedArr = new int[arr1L + arr2L + arr3L + arr4L];

        System.arraycopy(arr1, 0, combinedArr, 0, arr1L);
        System.arraycopy(arr2, 0, combinedArr, 5, arr2L);
        System.arraycopy(arr3, 0, combinedArr, 9, arr3L);
        System.arraycopy(arr4, 0, combinedArr, 14, arr4L);
        System.out.println("\nCombined array: \n" + Arrays.toString(combinedArr));

        Collection<Integer> arraySet = Arrays.stream(combinedArr)
                .boxed()
                .collect(Collectors.toSet());
        System.out.println("\nCombined array unique values only: \n" + arraySet);

        int arraySetSum = arraySet.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nSum of unique values is " + arraySetSum);

    }
}
