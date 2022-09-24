### Binary Search/Divide-N-Conquer

#### Divide-N-Conquer 2 Types
- One-Directional Approach : Binary Search, There are 2 paths, but you greedily select the right one
- Two-Directional Approach : Merge-Sort, solve both sub-problems, and merge sub-problem solution

#### Divide-N-Conquer Gyan
- Well Divide-N-Conquer and Greedy solutions actually are tougher than DP
- DP reduces exponential complexity to polynomial by using memorization, Divide-N-Conquer(like in merge sort) reduces polynomial(n^2) to (n*logn)
  - In problems Divide-N-Conquer, you don't have choice-tree like in DP, it would be problems involving `pair-wise-count` problems, which brute-force can solve in O(n^2), But think if you can use Divide-N-Conquer to make it O(logn).
  - [Pair-wise-count Problems](./Leetcode/src/main/java/year2k21/common/pattern/binarysearch/mergesort/variant)

#### Binary Search Tips
- Use Iteration or Only-Tail-Recursion to avoid call-stack auxiliary space (:bulb: Similar to LL suggestion)
- `DO NOT` try to optimize by having checks like if lowIndex or highIndex is having the "Searched number", it's an overkill
- Binary-Search 2 Types
  - All Distinct numbers in sorted array(Normal Binary search)
  - Duplicate numbers in sorted array (Similar to normal once, only remove the dups by shifting lowPointer to --> direction or highPointer to left direction). [Refer](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1890363/python-or-binary-search-or-explained-or)
- [Binary search Problem in rotated array, Two type of solution](./Leetcode/src/main/java/year2k21/common/pattern/sorting/SearchInRotatedSortedArray33.java)
  - Find min number of the array. Then you would find two sorted arrays, solve the problem
  - <pre>
    Find the mid-element
    If Left part sorted
        If num in-between of lo and mid
            Search in Left part
        Else 
            Search in Right part
    If Right part sorted
        If num in-between of mid and hi
            Search in Right part
        Else
            Search in Left part
    </pre>
  - [Similar Question, Find single One&Only Peak of Mountain](https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139849/Binary-Search) 
- BST Tricky Questions
  - [Find Local Maxima or Peak](./Leetcode/src/main/java/year2k21/common/pattern/binarysearch/FindPeakElement162.java)
    - Normal BT `low <= high`
    - This Problem `low < high`