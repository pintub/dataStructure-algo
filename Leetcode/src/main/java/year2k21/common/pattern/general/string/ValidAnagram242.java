package year2k21.common.pattern.general.string;

/**
 * O(2*n)
 */
public class ValidAnagram242 {

    public boolean isAnagram(String src, String tgt) {
        if(src.length() != tgt.length()) {
            return false;
        }

        int[] charVsExpectedCount = new int[26];//26 chars

        for(int count = 0; count < src.length(); count++){
            ++charVsExpectedCount[src.charAt(count) - 'a'];
        }

        for(int count = 0; count < tgt.length(); count++){
            int arrayIndex = tgt.charAt(count) - 'a';
            if(charVsExpectedCount[arrayIndex] == 0) {
                return false;
            }
            --charVsExpectedCount[arrayIndex];
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram242().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram242().isAnagram("rat", "car"));
    }
}
