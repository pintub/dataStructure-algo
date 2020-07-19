import java.util.Arrays;

public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        boolean canMakeArithmeticProgression = true;
        for (int count = 2; count < arr.length ; count++){
            if((arr[count] - arr[count-1]) != diff){
                canMakeArithmeticProgression = false;
                break;
            }
        }
        return canMakeArithmeticProgression;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1502().canMakeArithmeticProgression(new int[]{3,5,1}));
    }
}
