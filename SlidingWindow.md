### SLIDING WINDOW USING TWO POINTERS(Referred [Aditya Verma's series](https://www.youtube.com/watch?v=EHCGAZBbB88&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&ab_channel=AdityaVerma))

#### Question Hints
- Sub-Array/ Substring with maximum of something (Read Question carefully, these terms come in DP also)
- Largest Sub-Array/ Substring where something is something

#### intuition
- Question: For a given array, Find maximum sum of any Sub-array of size k
  - Brute force (Double Loop = O(n*k))
    - <pre>
      for (i = 0 -> arraySize) {
          for(j = i -> k) {
              //Calc windowSum    
          }
          sum = Math.max(sum, windowSum)
      }
      </pre>
  - Sliding Window solution (O(n))
    - Let's say k=3 ,When you have a window of indices [1, 2, 3], no need sum all numbers in window, rather newWindowSum =  previousWindowSum - outgoing number + incoming number 
    - `Memorization` :Use some sort of memorization for previous window computation, i.e. here previous window sum ,so Space complexity is O(1).<br/>
    Using right Memorization DS is `tricky` in Sliding Window problems.
- Common Tricks & Notes
  - `Where It gets complicated` ? Complexity is keeping tracking of where right is increased, when to process increased right pointer etc, Thus below template would definitely help. And you will rather focus on business logic. 
  - Window-Size = right - left + 1
  - Continue loop until `right < length` 
- Check code a template implementation of sliding window
  - [Fixed window Problem](Practice/src/main/java/com/p2/slidiing/window/fixed/MaxSumSubArrayOfSizeK.java) : Mostly 2 if-else "states" based on window size, i.e. One till the window size is reached(`Shift only Right pointer`). Other once window is reached, maintain the same size(`Shift Both pointers`)
    <pre>
        public static long maximumSumSubArray(int windowSize, List<Integer> array){
          //TWO Pointers
          int left = 0, right = 0;
          //"Memorization"
          long windowSum = 0;//Memorization for valid windows
          //"Result"
          long maxSum = Long.MIN_VALUE;
  
          while (right < array.size()) {//Need to remember this, Outer loop condition
              //Fixed size question, so increment Right pointer until window size is formed
              if (right - left + 1 < windowSize) {
                  windowSum += array.get(right);//"Update Memorization" by adding Right pointer based on Question
                  right++;
              } else if(right - left + 1 == windowSize) {//Once window size achieved, maintain the same size by 
                      //incrementing left and right pointers, This is where window of [left..right] is of size = windowSize
                  windowSum += array.get(right);//"Update Memorization" by adding Right pointer based on Question.
                      //Note this is repeated code, same as that of if() clause logic
                  right++;
  
                  maxSum = Math.max(maxSum, windowSum); //"Result Calculation"
                  windowSum -= array.get(left); //"Update Memorization" by removing Left pointer based on Question
                  left++;
              }
          }
          return maxSum;
        }
    </pre>
  - Variable window Problem: Mostly 2 if-else "states" based on ifWindowValid-Condition. i.e. One for valid window, other for invalid window. Most of the cases "ifWindowValid-Condition"(Example counter variable state, which depends on charVsCountMap "memo", which depends on rightPointer-character), compute memo and validity-condition before If-Clause itself. Check below algo. 
  <pre>
        public static long question() {
          //TWO Pointers
          int left = 0, right = 0;
          //"Memorization" DS 
          //"Result" variable

          while (right < array.size()) {//Need to remember this, Outer loop condition
              //If isValid condition depends on a DS, which depends on right-pointer char. Compute memo & isValid before If-clause
              //Update Memo
              //Determine "isValid"
              if (isValid) {
                  //"Update Result"
                  right++;
              } else {//"Move Only left pointer in a while loop until window is valid again"
                  while(is Not valid window) {
                    //"Update Memo" by removing outgoing left pointer value
                    left++;
                  }
                  //Here Valid window again achieved 
                  //"Update Result"
                  right++;
              }
          }
          return result;
        }
  </pre>

### Concepts
- `Counter variable concept` : To see if all values of a hashMap has become Zero . [Check code](./Practice/src/main/java/com/p2/slidiing/window/fixed/CountOccurrencesOfAnagrams.java)  

#### CHEAT-SHEET/Tips
- Using right Memorization DS is `tricky` in Sliding Window problems. Check Memorization DS of all problems
- Code of Walk through of edge cases, example if array ends with a valid window 
- Choices of popular Memorization DS
  - `Counter variable` :If Map is there and need to check if all values in Map is Zero. Note there are also variations to how "counter" can be used based on problems. Example: MinimumWindowSubstring76
  <pre>
    /**
    * Simple solution : Use a map of charVsCount and see if all values = respective expected Count.
    * Example If searchWord (aaba), then anagram found if a=3,b=1 map state has reached. This check is costly
    *
    * Instead, Counter variable used along w/ Map. Also decrement instead of incrementing count
    * Initialize Map to a=3,b=1 & counter var to 2 (which is no. of characters)
    * For all occurrence of char, decrease count from Map. But for counter if all chars are consumed expected times, Counter=0
    * Counter var will never be (-)ve
    *
    * If window has abba, Map will be a=1,b=-1 and counter will be =2 (When individual count is -ve, count rather increased)
    * If window has aaca, Map will be a=0,b=1 and counter will be =1 (as only "a" is consumed expected times)
    * If window has aaba, Map will be a=0,b=0 and counter will be =0 (as "a","b" both is consumed expected times)
    *
    * So, if all chars are consumed expected times, counter=0 and counter var will never be (-)ve
    * counter=0 vs checkAllValuesInMapIsZero() problem solved
    */
  </pre>
  - `Queue` : As we traverse through array and an element comes into queue first also gets removed first.<br/> 
  - `Dequeue`: Also used if both side operation required(Refer `SlidingWindowMaximum239`)

#### Exception Questions
- `SubstringWithConcatenationOfAllWords30` Multiple iteration Sliding Window
- `SubArraySumEqualsKWithNegativeNumbers560`, Not sliding window. Question has -ve numbers
  <pre>
    //Intuition if targetSum is Sum[2..5](Notice, this is continuous), Then There are Sum[0..5] & Sum[0..2]
    // where Sum[2..5] = Sum[0..5] - Sum[0..2] =>
    // Sum[0..2] =  Sum[0..5] - Sum[2..5] =>
    // Sum[0..2]/SmallerPrefixSum = Sum[0..5]/LargerPrefixSum - TargetSum
      // When you reached LargerPrefixSum, Check if SmallerPrefixSum existed
    
    //Find count of all <LargerPrefixSum, SmallerPrefixSum> pair

        sumTillNowVsCountOfSumTillNow.put(0, 1);//WHOAA!!! If TargetSum itself is present in the Array

        for (int i = 0; i < nums.length; i++) {//Keep tracking sumTillNow count, And check if any previous sumTillNow existed with targetSum difference
            sumTillNow += nums[i];

            count += sumTillNowVsCountOfSumTillNow.getOrDefault(sumTillNow - targetSum, 0);
            sumTillNowVsCountOfSumTillNow.put(sumTillNow, sumTillNowVsCountOfSumTillNow.getOrDefault(sumTillNow, 0) + 1);
        }
  </pre>
- `LongestRepeatingCharacterReplacement424` Not a DP
- New Concepts `LongestSubstringWithoutRepeatingCharacters3`, `SubarrayProductLessThanKOnlyPositiveNumbers713`
