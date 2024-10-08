### What is Backtracking ?
- Final solution is built incrementally (a prefix string or prefix array used for next recursion call). Type-2
  Recursion. When you reach end the leaf, the solution would be created.
- Rollback prefix Array/String/ArrayList like below example of Array Backtracking

### Terms
- Subsequence : Non-continuous, but position is ordered
    - 3-size Array, Find all subsequences. Total = 2^3 subsequences.
    - Example, For 123 => __Take/NoTake_"1"__ | __Take/NoTake_"2"__ | __Take/NoTake_"3"__
    - `Mechanism` : At any position, Take-DontTake approach.
- Subset : #Subsequence = #Subset. But subset can be of any order. If a question asks that find all subsets, You can find all subsequences
  - Example, For {1,2,3} , {3, 1} is subset, but not subsequence. For subsequence, you need {1,3}
  - `Mechanism` : At any position,Take-DontTake approach.
- Permutation : n! for a n-size Array or String, i.e. Generic Formula nPr = n!/(n-r)!, here nPn 
    - Example, For 123 => {123,132,231,213,312,321}
    - `Mechanism` : At any position,Take one from list of available candidates(But Take a candidate only once), as ordering duplicates needed
- Combinatation : nCr = n!/((n-r)! * r!)
    - Above Example, Combination = {123} , avoids duplicates in terms of ordering
    - #Permutations (considers ordering) > #Combinattions
  - `Mechanism` : At any position,TakeO-DontTake approach, as ordering duplicates should be avoided

### Meechanism Visualization
- At any position, Take-DontTake approach (Only once) (Subsequence/Subset/Combinatation)
- At any position, Take-DontTake approach (Unbounded)
- At any position,Take one from list of available candidates(But Take a candidate only once) (Permutation or Permutation Duplicates)
- At any position,Take one from list of available candidates(But Take a candidate any-times) (unbounded knapsack)
  
### Common Template of Code (Take or Dont Take )
- [CombinationSum39](https://github.com/pintub/dataStructure-algo/blob/master/Leetcode/src/main/java/year2k21/common/pattern/recursionANDbacktracking/date12042023/CombinationSum39.java)
- [SubsetsDuplicateII90](https://github.com/pintub/dataStructure-algo/blob/master/Leetcode/src/main/java/year2k21/common/pattern/recursionANDbacktracking/date12042023/SubsetsDuplicateII90.java) 

### Common Template of Code (Take one from list of available candidates)
- For String or Use StringBuilder as below in comments to avoid lot of unnecessary string creation
<pre>
    recursion(prefixStr, originalStr, ...) { //Notice prefix String Or Use sb , i.e.recursion(new StringBuilder(), originalStr, ...)
        if(prefixStr.length = originalStr.length) {
            sout(prefixStr); //Or Use SB sout(sb.toString())
            return;
        }

        For All candidate Char from originalStr
            recursion(prefixStr + candidateChar, originalStr, ...) // sb.append(candidateChar); recursion(sb, originalStr, ...); sb.deleteCharAt(sb.length() - 1);
    }
</pre>
- For ArrayList
<pre>
    recursion(prefixList, originalList, ...) { //Notice prefix Arr
        if(prefixList.length = originalArr.length) {
            sout(new ArrayList(prefixList));
            return;
        }

        For All candidate num from originalList
            prefixList.add(possibleNum);
            recursion(prefixList, originalList, ...);
            prefixList.remove(prefixList.size() - 1); // Why Backtracking is the name
    }
</pre>

### Types of Problems
- :rocket: Find all Subsequence of List or String . Time = O(2^n)
- :rocket: Find all Subset of List or String . Time = O(2^n)
- :rocket: Find all subsets with Target Sum variants(Non DP) . DP vs Backtracking .
  - :arrow_right: With -ve numbers . Don't Implement via DP, as DP won't work here .
  - :arrow_right: Print all subsets whose sum is Target Sum . Here you have to find all combinations of the input Array/String at any cost. <br/>
    If you apply "Target-Sum" DP, Space = O(m * n * 2^n) & Time = O(m * n * 2^n)(i.e. Each cell contains around 2^n data, at new cell new copy old cell data + a number, so copying is 2^n) .Think of Tabulation. 2D array of m * n and each cell can contain all combinations which is 2^n. Instead, Implement by Backtracking which is 2^n 
  - :arrow_right: Count all subsets whose sum is Target Sum . Implement via DP
- :rocket: Stop finding all combination <u>at some point</u>, Example find kth subsequence. Use Boolean functions.
<pre>
    bool recursion(prefixList, originalList, k, ...) { //Notice Return type
        if(prefixList.length = originalArr.length) {
            sout(new ArrayList(prefixList));
            if(k == 0)
              return true;
            return false;
        }

        For All candidate num from originalList
            prefixList.add(possibleNum);
            if(recursion(prefixList, originalList, k-1, ...))
              return true
            prefixList.remove(prefixList.size() - 1); 
        
        return false;
    }
</pre>
- Duplicate Permutation/Subset
  - Permutation : `Sort Array` & avoid dups using `if(idx != 0 && nums[idx] == nums[idx - 1]), continue` .
  - Subset : `Sort Array` & //If Excluding, then we will not add all the following same element, just jump to the index where nums[index] is a different value & If Including, Nothing Special
- Chess or Sudoku variant
<pre>
    bool recursion(prefixList, originalList, ...) {
        if(prefixList.length = originalArr.length) {
            sout(new ArrayList(prefixList));
            return;
        }

        For All candidate num from originalList
            if(!Is chess board or Sudoku valid after picking candidateNum) //Notice this
              continue;
            prefixList.add(possibleNum);
            if(recursion(prefixList, originalList, ...))
              return true
            prefixList.remove(prefixList.size() - 1);
        
        return false;
    }
</pre>
- [Problems](https://github.com/pintub/dataStructure-algo/tree/master/Leetcode/src/main/java/year2k21/common/pattern/recursionANDbacktracking/date12042023)
- Tricky Problems
  - :rocket: Find all subsets with dup elements in Array.
  - :rocket: Sudoku Solver. Check code & For loops <u>Must check the code</u>
  - :rocket: Find kth Permutation. <u>Nice code using mathematics</u>
  - :rocket: MColoringProblem(Not an extension of Graph BiPartite Problem)
