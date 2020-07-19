import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> allSquareSums = new HashSet<>(); allSquareSums.add(n);
        while (true) {
            int temp = n;
            n = 0;
            while (temp > 0 ){
                n += Math.pow(temp % 10, 2);
                temp = temp / 10;
            }
            if(n == 1){
                return true;
            }
            if(!allSquareSums.add(n)){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(73));
    }
}
