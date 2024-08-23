### Binary Search/Divide-N-Conquer
- When you have a solution of O(n^2). Try to think of sliding window or Divide and conquer

#### Divide-N-Conquer 2 Types
- One-Directional Problem: Binary Search, There are 2 paths, but you greedily select the correct one . O(logn)
- Two-Directional Problem: Merge-Sort, solve both sub-problems, and merge sub-problem solution . O(nlogn)

#### Divide-N-Conquer Gyan
- Recursion vs Divide n Conquer Gyan
  - How Time complexity= `nlogn`, T(n) = 2T(n/2) + θ(n), i.e. Merging happens only logn times & each merging is approx O(n).<br/>
    This is different from recursion tree where each node of tree does some computation, but in divide n conquer, Tree formed but each node does not do computation, rather merging node does computation
- Well Divide-N-Conquer and Greedy solutions actually are tougher than DP
- DP reduces exponential complexity to polynomial by using memorization, Divide-N-Conquer(like in merge sort) reduces polynomial(n^2) to (n*logn)
  - In problems Divide-N-Conquer, you don't have choice-tree like in DP, it would be problems involving `pair-wise-count` problems, which brute-force can solve in O(n^2), But think if you can use Divide-N-Conquer to make it O(logn).
  - `Note` the word "count" works with DnC, actual pairs not possible with these solutions

#### Two-Directional Problems
- [Count-Pair-Of-indices-With-A-Condition-Of_Pair Problems](./Leetcode/src/main/java/year2k21/common/pattern/binarysearch/mergesort/variant) : Count pair means any 2 number satisfying a condition, eg sum of elements from i to j > k "or" nums[i] > nums[j] * 2 "or"  ...
<pre>
  1. Choose which array which be part of mergesort. Here build PrefixCumulativeSum[] , size = inputSize + 1. 1st value in PrefixCumulativeSum[] = 0 . `Note`: PrefixCumulativeSum gets sorted in this process
  2. Global variable count = 0, Most of ques need count
  3. Use mergesort by passing above array
  4. Implement merge algorithm ,which is specific to problem statement. For each element in 1st half, find the other end of pair in 2nd half. 
  For example, for each element "k" in left half, find 2 points in right half such that pfxSum[i] - pfxSum[k] >= lower and pfxSum[j] - pfxSum[k] <= upper
  5. Then merge the sorted arrays. <u>Sometimes you can merge step 4 & 5</u>
</pre>
`Note`: the word "count" works with DnC, actual pairs not possible with these solutions
#### Binary Search Tips(One-Directional Problems)
- Use Iteration or Only-Tail-Recursion to avoid call-stack auxiliary space (:bulb: Similar to LL suggestion)
- `DO NOT` try to optimize by having checks like if lowIndex or highIndex is having the "Searched number", it's an overkill
- Binary-Search 2 Types
  - All Distinct numbers in sorted array(Normal Binary search)
  - Duplicate numbers in sorted array (Similar to normal once, only remove the dups by shifting lowPointer to right direction AND highPointer to left direction until dups are present). [Refer](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1890363/python-or-binary-search-or-explained-or)
  <pre>
      //Squeeze by removing Dups
      while (low <= high && low + 1 <= row.length - 1 && row[low] == row[low + 1]) {//Take Care of boundary Conditions
        ++low;
      }
      while (low <= high && high - 1 >= 0 && row[high] == row[high - 1]) {
        --high;
      }
  </pre>
- [Binary search Problem in rotated array, 2 Approaches](./Leetcode/src/main/java/year2k21/common/pattern/binarysearch/SearchInRotatedSortedArray33.java)
  - Approach1(2 Pass or 2*O(log n)): Find min number of the array. Then you would find two sorted arrays, solve the problem
    - How to find Min number ? Find mid-element. One part would be sorted and other part would be unsorted. Search in unsorted part. 
  - Approach2(1 Pass or O(log n): 
  <pre>
    Find the mid-element
    If Left part sorted
        If num in-between of lo and mid
            Search in Left part
        Else 
            Search in Right part
    Else If Right part sorted
        If num in-between of mid and hi
            Search in Right part
        Else
            Search in Left part
  </pre>
- [Similar Question, Find single One&Only Peak of Mountain](https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139849/Binary-Search)

#### Binary-Search/Merge-Sort Tricks
  - Be Careful of base condition for all problems. For example,
    - ~~MergeSort Recursion: low >= high, return; //Leaf node to have at-least 2 elements~~
    - ~~BinarySearch Recursion: low > high, return -1;BinarySearch Iteration: while(low <= high) //Leaf node can have 1 element~~
  - Be Careful while updating low/high pointer
    - Binary Search : high = mid + 1 or low = mid - 1
    - Sometimes: high = mid or low = mid
- Good Questions
  - Find Peak Element 162. Peak is any element bigger than neighbors and Corner elements are bigger than emptiness.
    - Hint : At Mid either slope is rising or falling or has crest or has Trough, Decide whether to go Left or Right or Return index  
  - Sqtr x Leetcode 69

#### Another Kind of Binary Search(Range binary Search)
- [Read](./com/p2/random/topinterviewques/KthSmallestElementInASortedMatrix378.java)
<pre>
/**
* Binary Search usually reduces "search-space" by selecting one direction.
* All questions known to me was Index-Binary search, low/high/mid are indices
*
* There is another type binary search which is Range-binary search. Example Below question. lo is the smallest number and the highest number. Mid is an number which may not exist in input[].
  *At "mid" check for the condition, here count of nums <= mid should be k
*
* Template :
*  low = lowest num
*  hi = highest num
*  while(low < high)
*      mid = low + (high - low) / 2; //Middle number in the Range
*      if(Traverse through input[] and check some conditionAroundMid)
*          Reduce hi or Increase low
*
* Time :
*      logn searches. Each search through input[] and check conditionAroundMid
*      O(nlogn)
*/
</pre>
