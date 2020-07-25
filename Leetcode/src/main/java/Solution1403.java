import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1403 {

    //Leetcode best solution
    //Use Array as map instead of Sorting

    //Using Sorting O(nlogn)
    public List<Integer> minSubsequenceV2(int[] nums) {
        int sum = 0;
        int size = nums.length;
        for (int num : nums){//O(n)
            sum += num;
        }

        Arrays.sort(nums);//O(nlogn)
        int subSequenceSum = 0;
        List<Integer> subSequence = new ArrayList<>();
        for(int count = size-1; count >= 0; count--){//O(n)
            subSequenceSum += nums[count];
            subSequence.add(nums[count]);
            if(subSequenceSum > sum - subSequenceSum){
                break;
            }
        }

        return subSequence;
    }

    //No need to sort completely , so manual sorting till you get subSequenceSum > Sum - subSequenceSum
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        int size = nums.length;
        List<Integer> subSequence = new ArrayList<>();

        for (int num : nums){//O(n)
            sum += num;
        }

        int subSequenceSum = 0;

        for(int i = 0; i < size-1; --size){//O(n^2)
            for (int j = i; j < size-1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
            subSequenceSum += nums[size-1];
            subSequence.add(nums[size-1]);
            if(subSequenceSum > sum - subSequenceSum){
                break;
            }
        }

        if(!(subSequenceSum > sum - subSequenceSum)){
            subSequence.add(nums[0]);
        }
        return subSequence;
    }

    private void swap(int[] arr, int a, int b){//Try without Temp
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1403().minSubsequence(new int[]{8}));
    }
}
