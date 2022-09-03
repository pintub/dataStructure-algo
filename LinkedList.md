### LinkedList

#### Reverse LL
- 2 Types (Node has link & value)
  - links are not changed, change values of node
  - values are not changed, change links of node (Mostly asked type)
- Reverse LL questions
  - Reverse LL
    - Iteration => Traverse the nodes{1,2,3,4} & build [1] => [2->1] => [3->2->1]=>[4->3->2->1]] :bulb: Intuition/Illustration of this most important for solving other problems 
    - Recursive, Same approach as above, Leads to tail recursion.
  - Reverse nodes between mth & nth nodes
  - Reverse nodes between nodeX & nodeY
  - [Reverse Nodes in k-Group](./Leetcode/src/main/java/year2k21/common/pattern/linkedlist/ReverseNodesInKGroup25.java) 

#### Tips
- Avoid swapping nodes using a function. It creates big mess, as reference itself gets reassigned & called reference variable will have different object
- Try tougher Reverse LL problems using Iterative, more intuitive & recursion might(? if non-tail recursion) take up O(n) space
- `Exceptions when to use Recursion`
  - Recursion can be used we want to reorder like [1st , last node], then [2nd, 2ndLast nodes], then [3rd, 3rdLast nodes] so on...
  - ifPalindromeLL(list), similar pairs involved [1st , last node], then [2nd, 2ndLast nodes], then [3rd, 3rdLast nodes] so on...  
- For Iterative problems, always cover the corner-cases at the beginning of method
- Common Tricks for different problems
  - Using a previousNode reference
  - Using two pointers
  - Using a dummy node pointing to head
  - count variable for node-count(This sometimes gets tricky :scream:) 

#### Tricky Questions
- [Reorder LL](./Leetcode/src/main/java/year2k21/common/pattern/linkedlist/ReorderList143.java), Uses both iteration +recursion