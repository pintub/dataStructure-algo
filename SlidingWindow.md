### SLIDING WINDOW USING TWO POINTERS(Referred [Aditya Verma's series](https://www.youtube.com/watch?v=EHCGAZBbB88&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&ab_channel=AdityaVerma))

#### Question Hints
- Sub-Array/ Substring with maximum of something (Read Question carefully, these terms come in DP also)
- Largest Sub-Array/ Substring where something is something

#### intuition
- Question: For a given array, Find maximum of Sub-array of size k
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
- [Check code a template implementation of sliding window](Practice/src/main/java/com/p2/slidiing/window/MaxSumSubArrayOfSizeK.java)

#### Types
- Fixed-sized window (Example, above question)
- Variable-size window(Example, Find largest sub-array of sum K)

### Concepts
- `Counter variable concept` : To see if all values of a hashMap has become Zero . [Check code](./Practice/src/main/java/com/p2/slidiing/window/CountOccurrencesOfAnagrams.java)  

#### CHEAT-SHEET/Tips
- Choices of popular Memorization DS
  - `Counter variable` :If Map is there and need to check if all values in Map is Zero
  - `Queue` : As we traverse through array and an element comes into queue first also gets removed first. Dequqe is also used if both side operation required(Refer SlidingWindowMaximum239)
- Using right Memorization DS is `tricky` in Sliding Window problems. Check Memorization DS of all problems
