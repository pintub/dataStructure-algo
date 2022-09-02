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
- Try tougher Reverse LL problems using Iterative, more intuitive 
- For Iterative problems, always cover the corner-cases at the beginning of method