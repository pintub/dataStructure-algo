package com.p2.random.topinterviewques.date042024;

public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int sLen = s.length();
        int right = sLen - 1;
        while(left < right) {
            while(left < sLen && isNonAlphaNumeric(Character.toLowerCase(s.charAt(left)))) {
                ++left;
            }
            while(right >= 0 && isNonAlphaNumeric(Character.toLowerCase(s.charAt(right)))) {
                --right;
            }

            if(left > right || Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }

    boolean isNonAlphaNumeric(char c) {
        return !(c >= 97 && c <= 122) &&
                !(c >= 48 && c <= 57);
    }

    public static void main(String[] args) {
        ValidPalindrome125 sol = new ValidPalindrome125();
        System.out.println(sol.isPalindrome(".,"));
    }


}
