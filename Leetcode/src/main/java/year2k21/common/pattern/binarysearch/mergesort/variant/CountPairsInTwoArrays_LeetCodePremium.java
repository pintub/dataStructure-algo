package year2k21.common.pattern.binarysearch.mergesort.variant;

/**
 * Question : https://leetcode.ca/2021-07-23-1885-Count-Pairs-in-Two-Arrays/
 *
 *
 * Couldn't think
 *      nums1[i] + nums1[j] > nums2[i] + nums2[j]
 *  ==> nums1[i] - nums2[j] > nums2[j] - nums1[i]
 *  ==> (nums1[i] - nums2[j]) + (nums1[i] - nums2[j]) > 0
 *
 *  So Create a diff[] and find pair where diff[j] + diff[i] >0 where j > i
 *  Uses same Merge-Sort
 *
 */
public class CountPairsInTwoArrays_LeetCodePremium {
}
