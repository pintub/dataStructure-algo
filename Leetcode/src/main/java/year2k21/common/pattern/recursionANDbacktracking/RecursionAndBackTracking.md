### What is Backtracking ?
- Final solution is built incrementally (a prefix string or prefix array used for next recursion call). Type-2
  Recursion. When you reach end the leaf, the solution would be created.
- Rollback prefix Array/String/ArrayList like below example of Array Backtracking

### Terms
- Subsequence : Non-continuous, but position is ordered
    - 3-size Array, Find all subsequences. Total = 2^3 subsequences.
    - Example, For 123 => __Take/NoTake_"1"__ | __Take/NoTake_"2"__ | __Take/NoTake_"3"__
- Subset : #Subsequence = #Subset. But subset can be of any order. If a question asks, find all subsets, you can find all subsequences
  - Example, For {1,2,3} , {3, 1} is subset, but on subsequence. For subsequence, you need {1,3}
- Permutation : n! for a n-size Array or String
    - Example, For 123 => {123,132,231,213,312,321}

### Common Template of Code
- For String
<pre>
    recursion(prefixStr, originalStr, ...) { //Notice prefix String
        if(prefixStr.length = originalStr.length) {
            sout(prefixStr);
            return;
        }

        For All candidate Char from originalStr
            recursion(prefixStr + candidateChar, originalStr, ...)
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
- :rocket: Find all subsets with Target Sum variants(Non DP) . DP vs Backtracking
  - With -ve numbers . DP won't work here .
  - Print all subsets whose sum is Target Sum . Here you have to find all combinations of the input Array/String at any cost. <br/>
    If you apply "Target-Sum" DP, Time = O(m * n * 2^n) .Think of Tabulation . 2D array of m * n and each cell can contain all combinations which is 2^n. Instead, Implement by Backtracking which is 2^n 
  - Count all subsets whose sum is Target Sum . Implement DP
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
- 2 Type of "Subset" problem-solving (Same concept as DP repetitive Target-Sum, But applicable here even without repetition)
  - Type1: Already discussed above. If you are at 2nd position, Take or no-Take the Element at 2nd position
  - Type2: "Sort input Array" and Then take one of rest of Elements
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
  - :rocket: Find all subsets with dup elements in Array. Apply "Type2" concept from above
  - :rocket: Sudoku Solver. Check code & For loops <u>Must check the code</u>
  - :rocket: Find kth Permutation. <u>Must check the code</u>
