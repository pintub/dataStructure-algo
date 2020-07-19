public class Solution1221 {
    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int output = 0;
        for(int count = 0; count < s.length(); count++){
            if(s.charAt(count) == 'L') ++countL;
            else ++countR;

            if(countL == countR) {
                ++output;
                countL = 0;
                countR = 0;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1221().balancedStringSplit("RLRRLLRLRL"));
    }
}
