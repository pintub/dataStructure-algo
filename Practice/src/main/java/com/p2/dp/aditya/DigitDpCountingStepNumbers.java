package com.p2.dp.aditya

import java.util.HashMap;
import java.util.Map;

/**
 * Can not have leading ZERO
 */
public class DigitDpCountingStepNumbers {

    private final int MOD = 1000000007;
    public int countSteppingNumbers(String low, String high) {
        Map<String, Long> memo = new HashMap<>();

        int countFrom1TillHigh = (int) (recursionCount(high.length(), 1, -1, high, memo) % MOD);

        //TODO map needs reset ? YES here
        memo = new HashMap<>();
        int countFrom1TillLowMinusOne = (int) (recursionCount(low.length(), 1, -1, low, memo) % MOD);

        return (countFrom1TillHigh - countFrom1TillLowMinusOne + isLowAStepNumber(low) + MOD) % MOD;
    }

    private int isLowAStepNumber(String s) {
        boolean isValid = true;
        for(int i = 0; i < s.length() - 1 && isValid; i++) {
            if(Math.abs(s.charAt(i + 1) - s.charAt(i)) != 1) {
                isValid = false;
            }
        }
        if(isValid) return 1;
        return 0;
    }

    //TODO use memo
    private long recursionCount(int startingFromPos, int tight, int previousDigit, final String rangeHighest, final Map<String
            , Long> memo) {
        String encodedValue = startingFromPos + "#" + tight + "#" + previousDigit;

        if(memo.get(encodedValue) != null) {
            return memo.get(encodedValue);
        }

        if(startingFromPos == 0) {
            memo.put(encodedValue, 1L);
            return 1;
        }

        int bound = tight == 0 ? 9 : rangeHighest.charAt(rangeHighest.length() - startingFromPos) - '0';
        long result = 0;

        for(int currentDigit = 0; currentDigit <= bound; currentDigit++) {
            if(previousDigit != -1 && Math.abs(currentDigit - previousDigit) != 1) {
                continue;
            }
            int newTight = tight == 0 ? 0 : currentDigit < bound ? 0 : 1;
            result += recursionCount(startingFromPos - 1, newTight
                    , (previousDigit == -1 && currentDigit == 0) ? -1 : currentDigit//Notice, Little tweak
                    , rangeHighest, memo);
            result %= MOD;
        }

        memo.put(encodedValue, result);
        return result;
    }

    public static void main(String[] args) {
        DigitDpCountingStepNumbers solution = new DigitDpCountingStepNumbers();
        System.out.println(solution.countSteppingNumbers("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    }
}
