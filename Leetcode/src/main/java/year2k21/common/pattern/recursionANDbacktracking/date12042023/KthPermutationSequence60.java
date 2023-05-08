package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.List;

/**
 * Optimized Solution Explanation : https://www.youtube.com/watch?v=wT7gcXLYoao&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=21
 *
 */
public class KthPermutationSequence60 {

    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {//Put 1,2,3... into numbers[] & fact = (n-1)!
            factorial = factorial * i;
            numbers.add(i);
        }
        numbers.add(n);

        String result = "";
        k = k - 1;

        while (true) {
            String currentPositionChar = "" + numbers.get(k / factorial);//Find char for Current Position
            result = result + currentPositionChar;

            numbers.remove(k / factorial);//Remove that number from numbers
            if (numbers.size() == 0) {
                break;
            }

            k = k % factorial;//What is Next k, For example n = 4, k = 17. 1st iteration , Find the 1st char for result which is numbers.get(16 / 3!) . Next find n = 3 , k = 16 % 3! = 4. So on...
            factorial = factorial / numbers.size();
        }
        return result;
    }

    private int count;
    public String getPermutationV2(int n, int k) {
        count = 0;
        int[] nArray = new int[n];

        return recursion("", nArray, n, k);
    }

    private String recursion(String prefix,int[] nArray, final int n, final int k) {
        if(prefix.length() == n) {
            ++count;
            if(count == k) {
                return prefix;
            }
            //System.out.println(prefix);
            return null;
        }

        for(int count = 0; count < nArray.length; count++) {
            if(nArray[count] == Integer.MIN_VALUE)
                continue;

            nArray[count] = Integer.MIN_VALUE;

            String str = recursion(prefix + (count + 1), nArray, n, k);
            if(str != null)
                return str;

            nArray[count] = 0;
        }

        return null;
    }

    public static void main(String[] args) {
        KthPermutationSequence60 sol = new KthPermutationSequence60();
        System.out.println("123".equals(sol.getPermutationV2(3, 1)));
        System.out.println("2314".equals(sol.getPermutationV2(4, 9)));
    }
}
