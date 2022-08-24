### DYNAMIC PROGRAMMING
- `Note` :rocket: are Problems

#### :crossed_swords:[Start w/ Alvin's Video](https://www.youtube.com/watch?v=oBt53YbR9Kk&ab_channel=freeCodeCamp.org)

##### DP Basics (DP = Recursion + Memorization )

###### Purpose
- Helps to reduce Exponential(Example 2^n) complexity to polynomial(Example n^2 or n^3) complexity.

###### How to identity problem
- While thinking of problem we will have one or more choices. Choices lead to `recursion`, where each choice is a branch of recursion tree
- Solve a little bigger recursion tree. If tree nodes are repeated, you can use `memorization`
- When we have choices and question talks about max/min optimization problems, It may be DP. :pill: Of-Course there is not short-cut to nothing.

###### DP Types
- Memorization/Top-Down (Recursion + Memo object)
  - Top-Down means -> Think of recursion tree. We start with Root node(Bigger input) and come down to leaf.
- Tabulation/Bottom-Up (Iteration + Memo object)
  - Top-Down means -> We start solving leaf node(smaller inputs) and move towards the biggest input

###### Steps for Solving any DP
- Start with Memorization approach
  - Figure out which input can be divided to sub-problems. Draw Recursion Tree with tha input as parameter
  - Add base conditions in tree
  - `Optimize` by identifying repetition of nodes, and using memo object to avoid repetitive calculation
  - Implement code
  - [How to code memorization](https://youtu.be/oBt53YbR9Kk?t=1565)
- Then you can move to Tabulation approach
  - Figure out which input is smallest sub-problems. Draw Table or Memo object starting with that input. 
  - :bulb: Sometimes table size = input-size + 1, because of 0-Indexing come into picture. Example Grid Traveller
  - Initialize table with default values, then initialize the smallest problem values into table 
  - `Optimize` space complexity of table by reducing table size to remove unnecessary space. Here time complexity remains same.
  - Implement code

###### [Recursion Time/Space Complexity basics](https://www.youtube.com/watch?v=oBt53YbR9Kk&t=648s)
- `Time Complexity = O(branchFactor ^ heightOfTree)`
- `Space Complexity = O(heightOfTree)`
- <details> 
    <summary>Example1</summary>
    <img src="resources/dp/TimeComplexityExample1.png" width="700" height="350" />
  </details>
- <details> 
    <summary>Example2</summary>
    <img src="resources/dp/TimeComplexityExample2.png" width="700" height="350" />
  </details>
- <details> 
    <summary>Example3 Brute-force Recursion Fibonacci, which forms Asymmetric recursion Tree</summary>
    O(dib) <= O(fib) <= O(lib) ==> Time O(fib) = O(2^n) , Space O(fib) = O(highestHeightOfTreeBranch) = O(n)
  </details>
- <details> 
    <summary>Example4 Memorized Recursion Fibonacci</summary>
    <img src="resources/dp/TimeComplexityExampleMemorizedFibonacci.PNG" width="700" height="350" />
  </details>
- :bulb: For any DP problem, try to find Time & space complexity from tabulation approach, as it is easy to visualize with memo table </br>
  Time complexity = #Table-Cells * #Each-Cell-Time-Complexity </br>
  Space complexity = #Table-Cells * #Each-Cell-Storage

##### Problems using both Memorization & Tabulation

###### :rocket: Fibonacci

###### :rocket: Grid Traveller Problem : gridTraveller(m, n)  2D m*n given. You may move right and down. In how-many ways you can move from top-left to bottom-right cell ? 
- Hint : gridTraveller(a, b) = gridTraveller(b, a). So space= O(m*n/2)

###### :rocket: canSum(targetSum, nums[]) Return true is targetSum can be generated using numbers of Array. canSum(7, {5, 3, 4, 7}) <br/>
  1. All numbers non-(-ve)
  2. You may use an element from array multiple times
- Question Resemblance : 2Sum, 3Sum problems of Array
- Hint : A number can be used multiple times, so Recursion tree parameter is only totalSum
- In Tabulation, at any index think ahead of future indices or at any index look back of existing indices

###### :rocket: howSum(targetSum, nums[]) Return any combination whose sum generates totalSum. canSum(7, {5, 3, 4, 7}) <br/>
  1. All numbers non-(-ve)
  2. You may use an element from array multiple times

###### :rocket: bestSum(targetSum, nums[]) Return any smallest combination whose sum generates totalSum. bestSum(7, {5, 3, 4, 7}) <br/>
  1. All numbers non-(-ve)
  2. You may use an element from array multiple times

###### :rocket: canConstruct("abcdef", {"ab", "abc", "cd", "def", "abcd"})<br/>
  1. You may use a word from array multiple times
- :alien: How do we create memo object . Hint: Form an array of size = targetStringSize + 1, Each position in array means if string upto current position(not included) can be formed
  - <details> 
      <summary>canConstruct() Tabulation Approach</summary>
      <img src="resources/dp/CanConstructMemoObject.PNG" width="500" height="250" /><br/>
      Index 3 means if "ab" can be constructed. How to check : If any of string in array ends with "b" AND targetString starts with "ab". Can be easily achieved via indexing.
    </details>
    
###### :rocket: countConstruct("abcdef", {"ab", "abc", "cd", "def", "abcd"})<br/>
  1. You may use a word from array multiple times
###### :rocket: allConstruct("abcdef", {"ab", "abc", "cd", "def", "abcd"})<br/>
  1. You may use a word from array multiple times

#### :crossed_swords:[Continue w/ Aditya Verma's Series](https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&ab_channel=AdityaVerma)

##### :rocket: 01-Knapsack. An item can be filled in knapsack 0 or 1 times, So not repeated times. Return mas profit.
##### :rocket: Can SubSet Problem or canSum, if a subset of given array can generate targetSum
##### :rocket: Is Equal-Sum-2-Partitions-Possible Problem. if 2 subset of given array can generate same sum => if a subset of given array can generate arraySum/2
##### :rocket: countSum. How many subsets of given array can generate targetSum ?
##### :rocket: minDifferenceOfTwoPartitions. Return the minimum difference of any 2 partitions of an array
##### :rocket: countWaysOfTwoPartitionsWithGivenDifference(nums[], difference). Return the count of possible ways where S1 - S2 = diff
##### :rocket: countWaysOfAssignPlusMinusToAchieveTargetSum(nums[], targetSum) . Return the count of possible ways where you can prefix + or - before array numbers and generate targetSum by adding-up 
##### :rocket: Unbounded Knapsack. Return mas profit.
- :bulb: How to build Recursion Tree, Two things come to mind
  - recursion(maxCapacity) . Using only maxCapacity as parameter and subtracting either of element in array is the choice
    - Not preferred, as doesn't work always. For example, If question asks about count number of was to achieve targetSum, it might count both {1, 2, 3} and {2, 1, 3} as ordering is not considered
    - Also branching factor is high. #Branches = #ArraySize
  - recursion(maxCapacity, arrayIndex) . Using both maxCapacity, currentArrayIndex as parameter and whether to consider the element at arrayIndex is the choice
    - `Preferred` No redundancy in output
    - Branching factor = 2
    - 01-knapsack Illustration
    <pre>                                      recursion(maxCapacity, arrayIndex)
                                                             /     \
                                                    Include /       \Exclude
                                                           /          \
                      recursion(maxCapacity-weight, arrayIndex-1)     recursion(maxCapacity, arrayIndex-1)
    </pre>
    - Unbounded-knapsack Illustration
    <pre>                                      recursion(maxCapacity, arrayIndex)
                                                               /     \
                                                      Include /       \Exclude
                                                             /          \
                        recursion(maxCapacity-weight, arrayIndex)     recursion(maxCapacity, arrayIndex-1)
    </pre>

##### :rocket: Rod cutting problem. A rod of length W to be cut into multiple pieces. Price of 2cm rod differs from 1cm rod price , Price[1, 2, 4] and length[1, 2, 3] is given. Means Price if 1cm, 2cm, 3cm is 1rs, 2rs, 4rs resp. Return mas profit
- :bulb: Sometimes Problem doesn't have length[] as it is just [1..rodLength]
##### :rocket: Coin change problem, Count Ways where coin can be added up to targetSum. A given coin(example 1rs) can be used multiple times. Sounds similar to countSum, only difference is 01 vs unbounded
##### :rocket: Coin change problem, Count Ways where coin can be added up to targetSum. A given coin(example 1rs) can be used multiple times. Sounds similar to countSum, only difference is 01 vs unbounded
##### :rocket: Coin change problem, Min# of coins which can be added up to targetSum. A given coin(example 1rs) can be used multiple times. Sounds similar to countSum, only difference is 01 vs unbounded
- recursion() return-value or table-cell value is min at that position
- Initialize table to Integer.MAX
##### LCS (Longest Common Subsequence) .Find LCS length or print LCS ?
- `SubSequence vs Substring` SubSequence need not be made of consecutive chars.
##### LCSS (Longest Common Substring) .Find LCSS length or print LCSS ?
- :bulb::clown_face: Till now you have seen problems where memo table each cell stores the result of a sub-problem. But here in LCSS that principle doesn't work. Actual result is outside the memo object and calculated separately, while memo object contents only help to derive actual result
##### Shortest Common Super-sequence. Given "geak" & "eke", output is "geake". Both "geak" & "eke" should be subsequence of output
- Print SCS
- Return Length = (str1Len + str2Len) - (LCS.length)
##### Min# Insertion & Deletion to convert str1 to str2. Example "heap" to "pea". Delete "h" & "p"(Notice "heap") and Insert "p"(Notice "pea")
- :bulb: Deletion# = str1Len - LCS.length, Insertion# = str2Len - LCS.length
##### LPS (Longest palindrome subsequence). Example Input :"agbcba", Output :"abcba"
- :bulb: LCS(str, reverseStr)
##### Min# Deletion to make a string a palindrome. Example Input : :"agbcba". Output= 1 (remove "g")
- :bulb:  Deletion# = strLen - LCS.len(str, reverseStr)
##### Min# Insertion to make a string a palindrome. Example Input : :"agbcba". . Output= 1 (Add "g")
- :bulb:  Insertion# = strLen - LCS.len(str, reverseStr)
##### LRS( Longest Repeating subsequence). Example Input :"AABEBCDD", Output :"ABD"
- :bulb: LCS(str, sameStr) and matching char condition => str[i] == str[j] & i != j, So same position matching is not considered matching.
##### Is subsequence . Given 2 strings if X is subsequence of Y
- :bulb: LCS(str1, str2) = smallestOf(str1, str2)
##### MCM (Matrix chain multiplication)/Partitioning type of DP problems
- :bulb: New Type of DP question
  - Usually recursion(i,j) can have multiple partitions. Recursively solve considering each partition and find best result. i <= Partition(k) < j
  - Always use TOp-down approach with MCM type questions
- Question: Given arr[] = {40, 20, 30, 10, 30}, Return min cost for multiplying the matrices represented by arr[] `or` put parenthesis around matrices for minimum cost. Here, 4 Matrices = {40*20, 20*30, 30*10, 10*30}. 
  - :bulb: Hint
    - Cost of Multiplication (Matrix(a*b), Matrix(b*c)) = #Multiplication Internally = a*b*c
    - A * B * C * D can be multiplied 3 types by using partitioning in between => (A) (BCD) or (AB)(CD) or (ABC) (D) 
##### Palindrome Partitioning. Given a string "nixin" how many min# portioning can be done so that each partition is a palindrome. Output : 2 n|ixi|n .Note maximum is partition @each character