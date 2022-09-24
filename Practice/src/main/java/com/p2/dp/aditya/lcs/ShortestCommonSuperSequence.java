package com.p2.dp.aditya.lcs;
/**
 * X = "geak"
 * Y = "eke"
 *
 * O/P = "geake"
 *
 * DP Choices :
 *          (2,3) //Matching chars
 *          / +e
 *         /
 *        (1, 2)
 *
 *              (4,3) //Not Matching chars
 *         +k   /   \+e(as "e" was ignored)
 *            /      \
 *         (3, 3)  (4, 2)
 */
public class ShortestCommonSuperSequence {
}
