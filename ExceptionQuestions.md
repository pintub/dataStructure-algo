### Exception Question with duplicate or -ve nums

| Problem |         |                                                                       |
|-------------------------------|---------------------------------|---------------------------------------------------------------------------------------------|
| Sum of window less than K     | +Ve nums(Sliding Window)        | -ve nums(preFixSum)                                                                         |
| Graph coloring                | 2 colors(BFS/DFS)               | -ve nums(BackTrackng)                                                                       |
| print all subsequnce          | print count(DP)                 | print All(BackTrackng)                                                                      |
| Target sum                    | +Ve nums(DP)                    | BackTracking                                                                                |
| Target sum +ve nums print all | print count (DP)                | BackTracking                                                                                |
| Find Element                  | Find highest frequent num(Heap) | Find highest frequent num if occures more than half of array size(Majority Element Problem) |
| LPS                           | LPS(similar to LCS)             | LPSS(Not similar to LCSS, Check Below)                                                      |

### New Questions
- Median of Two Sorted Arrays 		Binary Search O(log(m+n)) <br/>
  https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2496/concise-java-solution-based-on-binary-search/?envType=study-plan-v2&envId=top-interview-150	<br/>
- LPSS (Refer https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/?envType=study-plan-v2&envId=top-interview-150)<br/>
  Brute Force, find all substring in 2-for loop and check if each substring isPalindrome Approach 1<br/>
  DP to better above brute force , where isPalindrome() solved as dp, still using 2 for-loop Approach 3<br/>
  Expand around center, Take each index as center and expand left and right to find max palindrome Approach 2<br/>

### DFS(Recusrion or DP) vs BFS (Graph)
- Word Ladder 127 ([Use BFS & Why](https://github.com/pintub/dataStructure-algo/blob/master/Graph.md#crossed_swordscheat-sheettips)
