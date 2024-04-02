package com.p2.cyclicsort;

/**
 * Given range of integers 1..N
 * Sort the Array
 *
 * ~~~Intuition~~~ :
 *          Put current element in right index and Fill current index with right element
 *          Time O(n)
 * ~~~Question Pattern~~~
 *             1. Range of numbers given as input
 *             2. Find missing number(s) or duplicate(s)
 *
 * Input: arr[] = { 2, 1, 5, 4, 3} & Rng [1..5]
 * Output: 1 2 3 4 5
 * Explanation:
 *
 * Here Range of nums => [1..5]
 * Since arr[0] = 2 is not at correct position, then swap arr[0] with arr[arr[0] – 1]
 * Now array becomes: arr[] = {1, 2, 5, 4, 3}
 * Now arr[2] = 5 is not at correct position, then swap arr[2] with arr[arr[2] – 1]
 * Now the array becomes: arr[] = {1, 2, 3, 4, 5}
 * Now the array is sorted.
 *
 * Example
 *      {{@link com.p2.random.topinterviewques.MissingNumber268}}
 */
public class CyclicSorting {
}
