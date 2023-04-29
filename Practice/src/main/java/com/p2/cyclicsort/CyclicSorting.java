package com.p2.cyclicsort;

/**
 * Given range of integers 1..N
 * Sort the Array
 *
 * ~~~Intuition~~~ :
 *          Put current element in right index and Fill current index with right element
 *          Time O(n)
 * ~~~Question Pattern~~~
 *             Range of numbers given as input
 *             Find missing number(s) or duplicate(s)
 *
 * Input: arr[] = { 2, 1, 5, 4, 3}
 * Output: 1 2 3 4 5
 * Explanation:
 * Since arr[0] = 2 is not at correct position, then swap arr[0] with arr[arr[0] – 1]
 * Now array becomes: arr[] = {1, 2, 5, 4, 3}
 * Now arr[2] = 5 is not at correct position, then swap arr[2] with arr[arr[2] – 1]
 * Now the array becomes: arr[] = {1, 2, 3, 4, 5}
 * Now the array is sorted.
 */
public class CyclicSorting {
}
