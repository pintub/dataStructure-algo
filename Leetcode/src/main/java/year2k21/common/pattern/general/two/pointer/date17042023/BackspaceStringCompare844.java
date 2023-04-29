package year2k21.common.pattern.general.two.pointer.date17042023;

/**
 * Referred https://leetcode.com/problems/backspace-string-compare/solutions/135684/java-c-efficient-and-simple-solution-without-stack-etc/?orderBy=most_votes
 *
 * No need of 2 Pointers
 */
public class BackspaceStringCompare844 {
    public boolean backspaceCompare(String s, String t) {
        return transform(s).equals(transform(t));
    }

    private String transform(String str) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
