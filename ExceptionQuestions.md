### Exception Question with duplicate or -ve nums

| Problem |         |                                                                       |
|-------------------------------|---------------------------------|---------------------------------------------------------------------------------------------|
| Sum of window less than K     | +Ve nums(Sliding Window)        | -ve nums(preFixSum)                                                                         |
| Graph coloring                | 2 colors(BFS/DFS)               | M Colors(BackTrackng)                                                                       |
| print all subsequnce          | print count(DP)                 | print All(BackTrackng)                                                                      |
| Target sum                    | +Ve nums(DP)                    | -Ve nums(BackTracking)                                                                                |
| Target sum +ve nums print all | print count (DP)                | BackTracking                                                                                |
| Find Element                  | Find highest frequent num(Heap) | Find highest frequent num if occures more than half of array size(Majority Element Problem) |
| LPS                           | LPS(similar to LCS)             | LPSS(Not similar to LCSS, Check Below)                                                      |
| Peak of mountaain             | One Peak(852. Peak Index in a Mountain Array)             | Multiple peaks(162. Find Peak Element)  |

### Define your own DS to solve problems (This is kind of tricky for me, Thus collected Questions to brush up before interview)
#### Points
-    When element with counter deleted, you need the next count , Using DLL & HashMap combination
-    While deleting from each DS, check if complete deletion required or soft-delete needed


#### Questions
- 	380 Insert Delete GetRandom O(1)
- 	146 LRU
- 	460 LFU
-   432 Keep Count of like/dislike of videos
-   295 Find Median from Data Stream
-   211 Design Add and Search Words Data Structure
-   2671 Frequency Tracker
-   155 Min Stack
-   705 Design HashSet [use similar approach as HashMap)
-   706 Design HashMap [Use ListNode[], collision resolved using linked-list , If load factor is asked, rehash & shift data. ListNode<key,value, next>](https://leetcode.com/problems/design-hashmap/solutions/152746/java-solution/)
-   [353 Design Snake Game](https://algo.monster/liteproblems/353)
-   2034 Stock Price Fluctuation 

### Math Ques
- Pow(x)
- Sqrt(x), [Upto a precision](https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/)
- Non-Primes 1 to N
- Happy Number

### New Good Questions
- Median of Two Sorted Arrays 		[Binary Search O(log(m+n))](https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2496/concise-java-solution-based-on-binary-search/?envType=study-plan-v2&envId=top-interview-150)
- LPSS (Refer https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/?envType=study-plan-v2&envId=top-interview-150)<br/>
  Brute Force, find all substring in 2-for loop and check if each substring isPalindrome Approach 1<br/>
  DP to better above brute force , where isPalindrome() solved as dp, still using 2 for-loop Approach 3<br/>
  Expand around center, Take each index as center and expand left and right to find max palindrome Approach 2<br/>
- [LRU Cache 146 Implementation in O(1)](./Leetcode/src/main/java/com/p2/random/topinterviewques/LRUCache.java)
  - [Use `LinkedHashMap`](https://medium.com/@greekykhs/how-linkedhashmap-works-internally-in-java-409846a4f08)
  - It uses 2 DS (HashMap and Double LL), Use same object in both DS
    - HashMap, i.e. keyVsDLLNode. DLLNode class contains <key,value,prev,next>
    - Double LL of `Node`   
- LFU460 (Delete least frequent item. If more items with same freq, Use LRU) 
  - Need 3 DS
  - 1st is HashMap,i.e. keyVsDLLNode. DLLNode class contains <count,key,value,prev,next>
  - 2nd is HashMap,i.e. freqVsDLL, DLL contains DLLNode menionted in 1st point
  - minFrequency, Next minFreq is actually of the node which evicted min-frequent number
- [Gas Station (Greedy)](https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150)
- Jump Game I & II Greedy
  
### DFS(Recusrion or DP) vs BFS (Graph)
- Word Ladder 127 ([Use BFS & Why](https://github.com/pintub/dataStructure-algo/blob/master/Graph.md#crossed_swordscheat-sheettips)
- Word Search || (Use DFS) (A different Type of Graph Traversal, Starting from a cell in matrix, traverse graph where a cell can be visited multiple times via different Path i.e. A->C-B, A->D->B , B is visisted twice here. Use backtracking)
- [Work Break DP](https://leetcode.com/problems/word-break/description/)
