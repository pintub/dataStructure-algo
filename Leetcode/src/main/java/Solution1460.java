import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1460 {

    //HashMap(O(n) + O(n)) = O(n)
    public boolean canBeEqualV2(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : target){
            Integer num = map.get(i);
            map.put(i, num == null ? 1 : num + 1);
        }

        for (int i : arr){
            Integer num = map.get(i);
            if(num == null || num == 0)
                return false;
            else
                map.put(i, num - 1);
        }

        return true;
    }

    //Both Array Sorting and linear Search(O(nlogn) + O(n)) = O(nlogn + n)
    public boolean canBeEqualV3(int[] target, int[] arr) {

        if(target.length != arr.length)
            return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        for (int count = 0; count < arr.length ; count++){
            if(arr[count] != target[count])
                return false;
        }

        return true;
    }

    //Leetcode best solution, Array map instead of Hashmap
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        for(int n: arr)
            map[n]++;
        for(int n: target) {
            map[n]--;
            if(map[n]<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1460().canBeEqualV3(Util.createArray(1,1,2,2),
                Util.createArray(1,1,1,2)));
    }
}
