import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Solution1370 {

    //Using insertion Sort-like mechanism
    public String sortStringV3(String s) {
        StringBuilder finalOutputStringBuilder = new StringBuilder();
        int iterationCount = 0;
        while (s.length() > 0) {
            int inputStringSize = s.length();
            StringBuilder outputStringBuilder = new StringBuilder().append(s.charAt(0));
            StringBuilder newInputStringBuilder = new StringBuilder();

            for (int inputStringCount = 1; inputStringCount < inputStringSize; inputStringCount++) {
                char inputStringChar = s.charAt(inputStringCount);
                int outputStringSize = outputStringBuilder.length();

                for (int outputStringCount = 0; outputStringCount < outputStringSize; outputStringCount++) {
                    char outputStringChar = outputStringBuilder.charAt(outputStringCount);
                    if (inputStringChar < outputStringChar) {
                        if (outputStringCount == 0) {//Appending to Output String at the start or at middle
                            outputStringBuilder = new StringBuilder().append(inputStringChar).append(outputStringBuilder);
                        } else {
                            outputStringBuilder = new StringBuilder(outputStringBuilder.substring(0, outputStringCount))
                                    .append(inputStringChar)
                                    .append(outputStringBuilder.substring(outputStringCount, outputStringSize));
                        }
                        break;
                    } else if (inputStringChar == outputStringChar) {
                        newInputStringBuilder.append(inputStringChar);
                        break;
                    } if (outputStringCount == outputStringSize - 1){//Appending to Output String at the End
                        outputStringBuilder = new StringBuilder(outputStringBuilder).append(inputStringChar);
                        break;
                    }
                }
            }
            s= newInputStringBuilder.toString();
            finalOutputStringBuilder.append(iterationCount % 2 == 0 ?  outputStringBuilder :
                                        outputStringBuilder.reverse());
            ++iterationCount;
        }

        return finalOutputStringBuilder.toString();
    }

    //TreeMap Solution
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap();
        for (char c : s.toCharArray())
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        while (ans.length() < s.length()) {
            add(map, ans, true);
            add(map, ans, false);
        }
        return ans.toString();
    }

    private void add(TreeMap<Character, Integer> map, StringBuilder ans, boolean asc) {
        NavigableMap<Character, Integer> treeMap = (asc) ? map : map.descendingMap();
        for (Map.Entry<Character,Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() > 0) {
                ans.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
            }
        }
    }


    //Leetcode Best Solution
    public String sortStringV2(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray())
            ++count[c - 'a'];
        while (ans.length() < s.length()) {
            add(count, ans, true);
            add(count, ans, false);
        }
        return ans.toString();
    }
    private void add(int[] cnt, StringBuilder ans, boolean asc) {
        for (int i = 0; i < 26; ++i) {
            int j = asc ? i : 25 - i;
            if (cnt[j]-- > 0)
                ans.append((char)(j + 'a'));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1370().sortString("leetcode"));
    }
}