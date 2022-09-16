package year2k21.common.pattern.general.string;

import java.util.*;

/**
 * Question : https://leetcode.ca/all/271.html
 * Constraint :Input Strings only contain ASCII chars
 *
 * SSolution:
 *  Approach1 : Use a non-ASCII char as delimiter while encoding '日'
 *  Approach2 : For each String use "str.len#str" encoding. Example ["#ab4", "#xyz"] -> 4-#-#ab-4-#xyz (dashes are used only for readability)
 */
public class EncodeAndDecodeStrings271_LeetCodePremium {

    String encode(List<String> strs) {
        return "";
    }

    List<String> decode(String encodeString) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Non-ASCII:" + "日");
        System.out.println((int)'日');
    }

}
