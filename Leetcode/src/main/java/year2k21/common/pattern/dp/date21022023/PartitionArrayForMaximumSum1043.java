package year2k21.common.pattern.dp.date21022023;

import java.util.Arrays;

public class PartitionArrayForMaximumSum1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] memo = new int[arr.length + 1];
        Arrays.fill(memo, -1);

        return maxSumAfterPartitioning(0, arr, k, memo);
    }

    private int maxSumAfterPartitioning(int idx, int[] arr, final int k, int[] memo) {
        if(memo[idx] != -1)
            return memo[idx];

        if (idx == arr.length) {
            memo[idx] = 0;
            return 0;
        }

        /*if(idx > arr.length)
            return Integer.MIN_VALUE;*/

        int temp = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int count = 1; count <=k && idx + count - 1 <= arr.length - 1; count++) {
            max = Math.max(max, arr[idx + count - 1]);
            temp = Math.max(temp, maxSumAfterPartitioning(idx + count, arr, k, memo) + max * count);
        }

        memo[idx] = temp;
        return temp;
    }

    public static void main(String[] args) {
        PartitionArrayForMaximumSum1043 sol = new PartitionArrayForMaximumSum1043();
        System.out.println(sol.maxSumAfterPartitioning(new int[]{1}, 1));
    }
}
