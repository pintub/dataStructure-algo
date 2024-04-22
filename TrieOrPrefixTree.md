### TRIE OR PrefixTree

#### [Basics From Striver's Series](https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7&ab_channel=takeUforward)

##### Representation
<pre>
Class Node {//Version1 TRIE
    Node[26] charVsReferenceMap;
    boolean isEndOfAWord;
}
</pre>
##### Visual Representation
- Example: {day, wa, wax, way} . Note "day" has 3 chars, so Trie would have 4 nodes, with last having all null pointers<br/>
<img src="resources/trie/TrieExample.jpg" width="600" height="500" /><br/>
- `Leaf-Trie-Node` has all null pointers
- What Any Trie node refers ? You stand on a visual node, and can say what is the prefix lead to this and what next characters you can go from here. Root means no prefix and next chars are not-null array elements. Though a node doesn't have any info on prefix, visually you can relate this better.  
##### The Main Advantage
- Reduces space complexity. As duplicates words can be represented by same nodes.
- Helps to eliminate the duplicates if Prefix are same
- When there is a need to search/compare list of strings against list of strings. Example, Source List of Strings = {abc,def,xyz}, Other list of Strings = {abc,mno,xyd}. Normal way = O(m * n). Trie way = Build Trie with 1st list of String which is O(m) + Search 2nd list of Strings in Trie = O(n). <br/>Same advantage of Set or Map also. Put 1st list of Strings in Set which is O(m) + search 2nd list in set which is O(n)
- `Auto-Complete` feature : Stop at the node where search-keyword ends. Then all child nodes forms probable auto-complete words. 
- Can form a `File System Structure`
##### Trie Operations
- [insert(word)](./Practice/src/main/java/com/p2/trie/TrieInsertAndSearchOperation.java). `Note` insert() sets the state of non-array variables like count or boolean, which is used by search(), count() methods
  - Time = O(#AllCharsOfAllWords), <u>Space = Difficult to determine!!</u>
- search(word)
  - Time = O(#AllCharsOfWord)
- isAnyWordWithPrefix(prefix)
  - Time = O(#AllCharsOfWord)

#### Problems
##### :rocket: count(word), count(prefix), erase(word). `Note` word might have been added multiple times, So erase(word) erases only once by reducing countWord/countPrefix by 1. `When count is ZERO, actual nodes are not getting deleted.`
<pre>
Class Node {//Version2 TRIE
    Node[26] charVsReferenceMap;
    int countWord;   //Count of word which lead to this Node //"ew"
    int countPrefix; //Count of prefix which lead to this Node 
}
</pre>
<details> 
  <summary>Gif showing Count operation</summary>
  <img src="./resources/trie/TrieCountVersion.gif"/>
</details>

##### :rocket: isCompleteString(String[] words) : If all prefixes of a word is present in input words[]. Example words[] ={n, ni, nin. ninj. ninja, ninga}, output = ninja
- :bulb: "Two-Pass solution"
    - Insert all words to Trie Version-1, Time= O(#AllCharsOfAllWords)
    - For all words, check if all prefixes present, i.e. booleanFlag True at all steps(Except Root) till end of word, Time= O(#AllCharsOfAllWords)
##### :rocket: How many "Distinct" sub-strings in a Given String of n characters using TRIE
- `Notes` 
  - Notice The word "Distinct" here. Trie helps to eliminate Duplicates.
  - <u>Prefix is not same as substring. `Main challenge` is how to get all substrings of a string. Use 2 for loops.</u>
- Non-Trie approach: Using two for-loop, add all sub-strings in HashSet. Time = O(n ^ 2), space= O(#DistrinctSubStrings)
- Trie approach: Using two for-loop, add all sub-strings in Trie and Keep counting number of Trie nodes. Time = Same O(n ^ 2), Space = Optimized, Better than HashSet. Example String = "abc", HashSet would store {a, ab, abc, bc, b, c, ""}. Trie would store only 4 nodes because string with same prefix share nodes in Trie.
##### :rocket: Given int[] array & int k, find the max(k xor arrayElement)
- :bulb: How to represent integer in Trie
  - Convert integer -> 32 bit binary -> 32 char String where each char is 0 or 1. `Note` [No need to literally convert to binary-string, instead do binary operations to get/check/set bits](https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/). Example 31st bit is num >> 31
  - Insert bits of Integer left to right same as String characters. Example, To get 31st bit, use num >> 31 and store in root node.
  - <pre>
    Class Node {//Version3 TRIE
        Node[2] bitVsReferenceMap; //size 2 because only 0/1 possible
        //Other properties as per need
    }
    </pre>
- Solution to above Question using Trie
  - Insert all integers to Trie using Version3 Trie. O(n*32)
  - To maximize (anyNumber xor k)(let's take k=9=000...1001), we would love to have 111....111111 as xor result. So, we would need number to be opposite bits of k.<br/>
    So Traverse through all bits of k & for each bit check if opposite bit exists. If opp. bit exists, set 1 in that position of result, Else set 0. How to set 1-bit for any position? [Refer](./BinaryOperations.md). O(32)
 - Here the Trie solution has no advt yet, Refer next question for advt
##### :rocket: Given 2 non-negative integer arrays, find the max(anyElementFromArray1 xor anyElementFromArray2)
- :bulb: Extension of above problem. O(n * 32) (Insert Array1 of size n to Trie) + O(m * 32)(For each element of Array2 O(32) steps to find max XOR)
- Now you can notice the advt of this over brute-force approach. Brute-force is O(m * n) xors' .
##### :rocket: [Another big-fat Extension of above Question](https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020)
- :bulb: Sort input[] & Queries[](Sort Queries[] based on Ai)

#### Tips
- If Prefix or SubString-Count in Question, Think of TRIE. <u>Prefix is not same as substring. Main challenge is how to get all substrings of a string. Use 2 for loops.</u>
- If max XOR question for "non-negative" int[] array & given element "k", Think of TRIE Version-3
- If ques is regarding list of nums against another list of nums (example XOR ops) Or search list of strings against another list of strings(example Search ops), USE TRIE
