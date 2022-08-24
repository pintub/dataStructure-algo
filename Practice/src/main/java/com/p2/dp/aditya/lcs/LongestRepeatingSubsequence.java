package com.p2.dp.aditya.lcs;

/**
 *  * X = "AABCBDEE"
 *  *
 *  * O/P = "ABE"
 *
 *  Find LCS of X & X(yeah same X)
 *  *
 *  * DP Choices :
 *  *          (1,2) //Matching chars, Different index
 *  *          / + A
 *  *         /
 *  *        (0, 1)
 *
 *  *          (1, 1) //Matching chars, But same index => Not matching
 *  *          /    \
 *  *         /      \
 *  *        (0, 1)  (1, 0)
 *  *
 *  *              (1,3) //Not Matching chars
 *  *             /    \
 *  *            /      \
 *  *         (0, 3)  (1, 2)
 */
public class LongestRepeatingSubsequence {
}
