### Binary Search

#### Tips
- Use Iteration or Only-Tail-Recursion to avoid call-stack auxiliary space (:bulb: Similar to LL suggestion)
- `DO NOT` try to optimize by having checks like if lowIndex or highIndex is having the "Searched number", it's an overkill
- Two types of Binary-Search
  - All Distinct numbers in sorted array(Normal Binary search)
  - Duplicate numbers in sorted array (Similar to normal once, only remove the dups by shifting lowPointer to --> direction or highPointer to left direction). [Refer](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1890363/python-or-binary-search-or-explained-or)
- [Binary search in rotated array, Two type of solution](./Leetcode/src/main/java/year2k21/common/pattern/sorting/SearchInRotatedSortedArray33.java)
  - Find min number of the array. Then you would find two sorted arrays, solve the problem
  - <pre>
    Find the mid-element
    If Left part sorted
        If num in-between of lo and hi
            Search in Left part
        Else 
            Search in Right part
    If Right part sorted
        If num in-between of lo and hi
            Search in Right part
        Else
            Search in Left part
    </pre>
  - [Similar Question, Find Single One&Only Peak of Mountain](https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139849/Binary-Search) 

#### Tricky Question
- [Find Local Maxima or Peak](./Leetcode/src/main/java/year2k21/common/pattern/binarysearch/FindPeakElement162.java)
  - Normal BT `low <= high`
  - This Problem `low < high`