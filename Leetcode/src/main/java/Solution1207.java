import java.util.HashSet;
import java.util.Set;

public class Solution1207 {

    //Using array as Map
    public boolean uniqueOccurrencesV2(int[] arr) {
        int[] arrayMap = new int[2000];//Number range -1000 <= arr[i] <= 1000
        //index = num + 1000 and array value = frequency

        int range = 1000;
        for(int i: arr){
            ++arrayMap[i + range];
        }

        Set<Integer> frequencies = new HashSet<>();
        for(int frequency: arrayMap){
            if(!frequencies.add(frequency) && frequency != 0){
                return false;
            }
        }
        return true;
    }

    //Using array as Map and 2 sets . Didn't try with HashMap instead of (uniqueNums + arrayMap)
    //May be for Discrete integer list HashMap is better than array-like Map
    public boolean uniqueOccurrences(int[] arr) {
        int[] arrayMap = new int[2000];//Number range -1000 <= arr[i] <= 1000
        //index = num + 1000 and array value = frequency

        Set<Integer> uniqueNums = new HashSet<>();

        int range = 1000;
        for(int i: arr){
            ++arrayMap[i + range];
            uniqueNums.add(i);
        }


        Set<Integer> frequencies = new HashSet<>();
        for(int i: uniqueNums){
            if(!frequencies.add(arrayMap[i + range])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1207().uniqueOccurrences(new int[]{1,2,1,2,4,3}));
    }
}
