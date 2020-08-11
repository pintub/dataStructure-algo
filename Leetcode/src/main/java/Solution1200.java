import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1200 {

    //Sort First, Then first min difference considering adjacent elements
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);//O(n*logn)
        int minDifference = 1000000;//Max difference possible between adjacent numbers -> 19 * 10^5
        List<List<Integer>> output = new ArrayList<>();
        for(int count = 0; count < arr.length - 1; count++){//O(n)
            int diff = Math.abs(arr[count] - arr[count+1]);
            if(diff < minDifference){
                minDifference = diff;
                output.clear();
                output.add(Arrays.asList(arr[count], arr[count + 1]));
            } else if(diff == minDifference){
                output.add(Arrays.asList(arr[count], arr[count + 1]));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1200().minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
    }

}
