import java.util.Arrays;

public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int[] charFreqMap = new int[26];//26 characters
        for(int count = 0; count < chars.length(); count++){
            ++charFreqMap[chars.charAt(count) - 97];
        }
        int charsMapLength = charFreqMap.length;

        int sum = 0;
        for(String word : words){
            boolean isGoodWord = true;
            //int[] tempMap = charFreqMap.clone();
            int[] tempMap = Arrays.copyOf(charFreqMap , charsMapLength);
            if( word.length() > chars.length()){
                continue;
            }
            for(int count = 0; count < word.length(); count++){
                int charToInt = word.charAt(count) - 97;
                if(--tempMap[charToInt] < 0 ){
                    isGoodWord = false;
                    break;
                }
            }
            if(isGoodWord){
                sum += word.length();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1160().countCharacters(new String[]{"hello","world","leetcode"},
                "welldonehoneyr"));
    }
}
