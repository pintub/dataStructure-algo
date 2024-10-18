package com.p2.dp.aditya;

import java.util.HashMap;
import java.util.Map;

/**
 * 2 types of problems
 *
 * Type1: Give count of nums in range [1,High] where eligible num's digits obey some property, i.e. sum of digits = 10, diff of digits = 1 etc
 * Type2 : Give count of nums in range [low,High] where eligible num's digits obey some property
 *          solve(high) - solve(low - 1)
 *          NOTE: Sometimes memo needs reset, sometimes not
*  Constraints:
 *      0 <= low <= high <= 10^100 (i.e. 100 digits)
*
 *      Dp Recursion :
 *          [Going left to Right, i.e. MSB to LSB]
 *
 *          [startingFromPosition is left to right, i.e. MSB to LSB
 *          left most startingFromPosition is high.length - 1]
 *
 *          [tight decides whether current digit is restricted i.e. bound by high's digit at that position, if restricted,tight = 1,
 *              if not restricted , tight=0]
 *
 *          recursion(startingFromPosition, tight, customVarRelatedToDigitProperty) =
 *              //sum of for loop
 *              for(currentDigit=0 -> bound) {
 *                  recursion(startingFromPosition - 1, "newTight", "new customVarRelatedToDigitProperty")
 *              }
 */
public class DigitDpSumOfDigitsX {

    public long countOfNumbersWhereSumOfDigitsIsX(String low, String high, final int x) {
        Map<String, Long> memo = new HashMap<>();

        long countFrom1TillHigh = recursionCount(high.length(), 1, x, high, memo);

        //TODO reset Map ?? No Need here
        String lowMinusOne = String.valueOf(Integer.parseInt(low) - 1);
        long countFrom1TillLowMinusOne = recursionCount(low.length(), 1, x, lowMinusOne, memo);

        return countFrom1TillHigh - countFrom1TillLowMinusOne;
    }

    private long recursionCount(int startingFromPos, int tight, int x, final String rangeHighest, final Map<String
            , Long> memo) {
        String encodedValue = startingFromPos + "#" + tight + "#" + x;

        if(startingFromPos == 0 && x == 0) {//TODO Check
            memo.put(encodedValue, 1L);
            return 1L;
        }

        if(startingFromPos == 0) {
            memo.put(encodedValue, 0L);
            return 0L;
        }

        if(memo.get(encodedValue) != null) {
            return memo.get(encodedValue);
        }

        int bound = (tight == 0) ? 9 : rangeHighest.charAt(rangeHighest.length() - startingFromPos) - '0';

        long result = 0;

        for(int currentDigit = 0 ; currentDigit <= bound; currentDigit++) {//NOTE, starting from Zero. This ensures potential numbers of digit length are covered
            int newTight = tight == 0 ? 0 : currentDigit < bound ? 0 : 1;

            if(x - currentDigit < 0) {
                break;
            }
            result += recursionCount(startingFromPos - 1, newTight, x - currentDigit, rangeHighest, memo);
        }

        memo.put(encodedValue, result);

        return result;
    }

    public static void main(String[] args) {
        DigitDpSumOfDigitsX digitDp = new DigitDpSumOfDigitsX();
        System.out.println(digitDp.countOfNumbersWhereSumOfDigitsIsX("69", "1120343423443535", 15));
    }
}
