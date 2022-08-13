package year2k21.common.pattern.sorting;

/**
 * Don't try to maintain a sorted DS or PQ which is an overhead,
 * you have to sort for each push or pop
 *
 * Need to do @ O(1) pop and push
 *
 * https://leetcode.com/problems/maximum-frequency-stack/solution/
 *     Map<Integer, Integer> freq; //NumVsFreq
 *     Map<Integer, Stack<Integer>> group; //FreqVsElements If x has freq=2 [<1, Stack[x]>, <2,Stack[x]> (inserted twice)
 *     int maxfreq; /Max freq of any number
 */
public class MaximumFrequencyStack895 {

    public MaximumFrequencyStack895() {
    }

    public void push(int val) {
    }

    public int pop() {
        return -1;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack895 freqStack = new MaximumFrequencyStack895();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the
    }

}
