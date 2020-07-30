import java.util.ArrayList;
import java.util.List;

public class Solution1002 {

    public List<String> commonChars(String[] A) {
        int size = A.length;
        int[] charCountMap = new int[26];//26 letters

        for(char c: A[0].toCharArray()){
            ++charCountMap[c - 'a'];//Char to int conversion
        }
        for(int count =1; count < size; count++){//O(n)+O(26)
            int[] tempCharCountMap = new int[26];//26 letters
            for(char c: A[count].toCharArray()){
                ++tempCharCountMap[c - 'a'];//Char to int conversion
            }
            min(charCountMap, tempCharCountMap);
        }

        List<String> output = new ArrayList<>();
        for(int count = 0; count < 26; count++){//O(26) + O(outputSize)
            int charCount = charCountMap[count];
            if(charCount > 0){
                for(int i = 1; i <= charCount ; i++){
                    char c = 'a';
                    c += count;
                    output.add(String.valueOf(c));//int to char conversion
                }
            }
        }

        return output;
    }

    private void min(int[] charCountMap, int[] tempCharCountMap) {
        for(int count = 0; count < 26; count++){
            charCountMap[count] = Math.min(charCountMap[count], tempCharCountMap[count]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1002().commonChars(new String[]{"acabcddd","bcbdbcbd"}));
    }
}
