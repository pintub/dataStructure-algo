import java.util.Arrays;

public class Solution1051 {
    //Using Sorting O(nlogn)+2*O(n)
    public int heightCheckerV2(int[] heights) {
        int[] heightSCopy = heights.clone();//O(nlogn)
        Arrays.sort(heights);//O(n)

        int moveCount = 0;
        int heightsSize = heights.length;
        for(int count = 0; count < heightsSize; count++){//O(n)
            if(heights[count] != heightSCopy[count]){
                ++moveCount;
            }
        }

        return moveCount;
    }

    //Leetcode Best solution, Using Array as Map
    //Array as Map is efficient here as number of elements are less 1 to 101
    //SO SO, Array map can be used instead of Sorting O(Numbers Range) vs O(nlogn)
    public int heightChecker(int[] heights) {
        int[] frequencyMap = new int[101];//Index -> Number , Value -> Frequency
        for(int height : heights){
            ++frequencyMap[height];
        }

        int moveCount = 0;
        int heightIndex = 0;
        for(int freqCount = 0; freqCount < frequencyMap.length ; freqCount++){//O(100)
            for(int count = 0 ; count < frequencyMap[freqCount] ; count++){//O(n)
                if(heights[heightIndex] != freqCount){
                    ++moveCount;
                }
                ++heightIndex;
            }
        }

        return moveCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1051().heightChecker(new int[]{5,1,2,3,4}));
    }
}
