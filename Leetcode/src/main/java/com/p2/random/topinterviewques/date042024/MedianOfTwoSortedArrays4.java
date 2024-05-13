package com.p2.random.topinterviewques.date042024;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Quick select
        int len = nums1.length + nums2.length;
        List<Integer> indexToFind = new ArrayList<>();
        indexToFind.add(len / 2);
        if(len % 2 == 0) {//even
            indexToFind.add(len / 2 - 1);
        }

        quickSelect(0, len - 1, new ArrayList<>(indexToFind), nums1, nums2);

        double result = 0;
        for(int index : indexToFind) {
            result += getValueByIndex(index, nums1, nums2);
        }

        return result / indexToFind.size();
    }

    void quickSelect(int startIdx, int endIdx, List<Integer> indexToFind, int[] nums1, int[] nums2) {
        if(startIdx == endIdx) {
            indexToFind.remove(Integer.valueOf(startIdx));
            return;
        }

        int pivotIndex = endIdx;
        int partitionIdx = partition(startIdx, endIdx, pivotIndex, nums1, nums2);//TODO
        if(indexToFind.contains(partitionIdx)) {
            indexToFind.remove(Integer.valueOf(partitionIdx));
        }

        if(indexToFind.isEmpty()){
            return;
        }

        if(partitionIdx < indexToFind.get(0)) {
            quickSelect(partitionIdx + 1, endIdx, indexToFind, nums1, nums2);
        } else {
            quickSelect(startIdx, partitionIdx - 1, indexToFind, nums1, nums2);
        }
    }

    int partition(int startIdx, int endIdx, int pivotIndex, int[] nums1, int[] nums2) {
        int i = startIdx - 1;
        for(int j = startIdx; j<endIdx; j++) {
            if(getValueByIndex(j, nums1, nums2) <= getValueByIndex(pivotIndex, nums1, nums2)) {
                ++i;
                if(i != j) {
                    swap(i, j, nums1, nums2);
                }
            }
        }

        swap(i + 1, pivotIndex, nums1, nums2);

        return i + 1;
    }

    int getValueByIndex(int index, int[] nums1, int[] nums2) {
        if(index < nums1.length){
            return nums1[index];
        } else {
            return nums2[index - nums1.length];
        }
    }

    void swap(int idx1, int idx2, int[] nums1, int[] nums2) {
        if(idx1 == idx2)
            return;

        if(idx1 < nums1.length && idx2 < nums1.length) {//Both in 1st Array
            int temp = nums1[idx1];
            nums1[idx1] = nums1[idx2];
            nums1[idx2] = temp;
        } else if (idx1 >= nums1.length && idx2 >= nums1.length) {//Both in 2nd Array
            int temp = nums2[idx1- nums1.length];
            nums2[idx1- nums1.length] = nums2[idx2 - nums1.length];
            nums2[idx2 - nums1.length] = temp;
        } else if (idx1 < nums1.length && idx2 >= nums1.length) {//1st in 1st arr, 2nd in 2nd Arr
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2 - nums1.length];
            nums2[idx2 - nums1.length] = temp;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays4 sol = new MedianOfTwoSortedArrays4();
        int[] nums1 = new int[]{2,3,4};
        int[] nums2 = new int[]{1};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}
