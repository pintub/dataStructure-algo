package year2k21.common.pattern.heap.date24012023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Using Bucket Sort approach for O(n) time complexity
 *
 * Space
 *  Map O(n)
 *  Buckets O(n)
*  So, O(n)
 */
public class TopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null) {
            return null;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {//O(n)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //Bucket
        List<Integer>[] freqVsNumbersBuckets = new List[nums.length + 1]; //Bucket from 0 to nums.length
        for(Map.Entry<Integer, Integer> numVsFrequency : frequencyMap.entrySet()) {
            if(freqVsNumbersBuckets[numVsFrequency.getValue()] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(numVsFrequency.getKey());
                freqVsNumbersBuckets[numVsFrequency.getValue()] = list;
            } else {
                freqVsNumbersBuckets[numVsFrequency.getValue()].add(numVsFrequency.getKey());
            }
        }

        int kCount = 0;
        int[] result = new int[k];
        for(int frequency = nums.length; frequency >= 0; frequency--) {
            List<Integer> numbers = freqVsNumbersBuckets[frequency];
            if(numbers == null) {
                continue;
            }

            for(int num : numbers){
                result[kCount] = num;
                kCount++;
                if(kCount == k){
                    break;
                }
            }

            if(kCount == k){
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements347().topKFrequent(new int[]{1}, 1)));
    }
}
