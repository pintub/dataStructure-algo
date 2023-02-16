### DISJOINT SET (Referred Karumanchi Book)
- Purpose
  - Find & Union
    - Find(X) => Find name of Set where X is present & Union(Find(X), Find(Y)) => Union of sets where X & Y present. `Note` First find, then union Operation makes sense
  - Question Types : Relationship, Friendship question
- Visualization vs Implementation
  - Visualization is in Tree, but Implementation is in `Array` just like Heap
  - Time complexity is asked in terms of "What is time complexity if "m" Find and Union operations are done"
- Implementation Types
  - :rocket: Quick Find (`Note` Not popular)
    - Implementation
      - Array Map , i.e. index => element, value => set name
    - Time Complexity
      - Find operation = O(1)
      - Union operation(i.e. union of i & j sets) = O(n), as we have to iterate through whole array to find all "i" and convert to "j"
      - m Find/Union operations = m*O(1) + m*O(n) = m*O(n)

Example, here Find[3] = Set j

| i | j | i | j | <-- Set Name |
|---|---|---|---|--------------|
| 0 | 1 | 2 | 3 | <-- Element  |
 
  - :rocket: Quick Union Plain (`Note` Not popular)
     - Concept
       - Disjoint Set is represention as multiple trees, where each tree is like Set. 
       - Set of an element is identified by root of tree instead of a set-name. Each element keeps its parent node in array and root keeps itself in array.
       - So for Find(X), traverse from X till root(can be identified by self pointer) and return the root
     - Implementation
       - Array Map , i.e. index => element, value => parent node 
       - Array[root] = root
       - During Array Map initialization, Array[i] = i, i.e. self pointer
     - Time Complexity
       - Find operation = O(n) ,Worst case if Tree becomes skewed
       - Union operation = O(1), Just randomly assign parent of root1 as root2, Array[root1] = root2
       - m Find/Union operations = m*O(n) + m*O(1) = m*O(n)
  - :rocket: Quick Union by Weight or Size(number of nodes in Tree)
    - Concept
      - To solve skewed tree problem in above solution to keep height of tree shorter
      - While unionising 2 tree, make smaller tree a subtree of larger tree
      - Root instead of pointing to itself stores (-ve) of tree size
    - Implementation
        - Array Map , i.e. index => element, value => parent node
        - Array[root] = -TreeSize
        - During Array Map initialization, Array[i] = -1, as 1 is tree size of only one node
    - Time Complexity
        - Find operation = O(log n) . `Big Note` if log is not of base 2 as tree can have more than 2 branches
        - Union operation = O(1)
        - m Find/Union operations = m*O(log n) + m*O(1) = m*O(log n)
  - :rocket: Quick Union by height or Rank
    - Concept
      - To solve skewed tree problem in above solution to keep height of tree shorter
      - While unionising 2 tree, make smaller tree a subtree of larger tree
      - Root instead of pointing to itself stores (-ve) of tree height
    - Implementation
      - Array Map , i.e. index => element, value => parent node
      - Array[root] = -TreeHeight
      - During Array Map initialization, Array[i] = -1, as 1 is tree height of only one node
      - :bulb: Height increased by 1 iff both tree size are same, else one root is made child of another root simply<br/>
      <pre>
        if (elementVsSetNameMap[root1] == elementVsSetNameMap[root2])  {
            elementVsSetNameMap[root2] = root1;
            elementVsSetNameMap[root1] += -1;//Height increased by 1
        } else if (elementVsSetNameMap[root1] < elementVsSetNameMap[root2])  {//Root1 Bigger, So Make Root2 subtree of Root1
            elementVsSetNameMap[root2] = root1;
        } else {
            elementVsSetNameMap[root1] = root2;
        }
      </pre>
    - Time Complexity
      - Find operation = O(log n) . `Big Note` if log is not of base 2 as tree can have more than 2 branches
      - Union operation = O(1)
      - m Find/Union operations = m*O(log n) + m*O(1) = m*O(log n)
  - :rocket: Quick Union by Weight or height with Path Compression
    - Concept
      - Further, Find(X). While finding Find(X), we traverse from X till root, so cache & mark Array[x or any_node_on_th_way_from_X_till_Root] = Root. Next time Find[X] is asked, you don't have to traverse again.
      - [Refer Diagram](./resources/disjointSet/PathCompression.PNG)
    - Compatibility w/ Quick Union by Weight or Height
      - By Weight has no issues
      - By Height might be confusing, as we just change array value of X till root to store direct root, But array value of root is not change, it still stores the (-ve) value of height. But no issues with this. Here height stored at root is upper bound of tree height.
    - Implementation
      - Find(X) implementation is changed
    - Time Complexity
      - Find operation = O(1) . `Big Note` 2nd Find Onwards of that element
      - Union operation = O(1)
      - m Find/Union operations = m*O(1) + m*O(1) => `Amortized` Time complexity is almost constant time

#### Cheat-Sheet/Tips 

- ArrayMap is used, Index => Element, Value => Set-Name
  - In case of non-integer question or character question, map character to integer. WHY? cause index of ArrayMap needs to be Integer 
  - :bulb: Alternatively, `ArrayMap can be replaced by Map<node, parentNode>` . It's useful in-case of String or Character Question. [Example merge Person's email Ids](./Leetcode/src/main/java/year2k21/common/pattern/unionfind/date15022023/AccountsMerge721.java)
- `MakeSet()` -> Initialization of ArrayMap

| Algorithm                                        | Popularity | Variation                                                                                         | Single Find Op | Single Union Op | "m" Find/Union Ops |
|--------------------------------------------------|------------|---------------------------------------------------------------------------------------------------|----------------|-----------------|--------------------|
| Quick Find                                       | Less       | Array[elem] storing Set name                                                                      | O(1)           | O(n)            | m*O(n)             |
| Quick Union Plain                                | Less       | Array[elem] storing Parent node and Array[Root] storing itself                                    | O(n)           | O(1)            | m*O(n)             |
| Quick Union Weight/Size                          | Good       | Array[elem] storing Parent node and Array[Root] storing (-ve)TreeNumberOfNodes                    | O(log n)       | O(1)            | m*O(log n)         |
| Quick Union Height/Rank                          | Good       | Array[elem] storing Parent node and Array[Root] storing (-ve)TreeHeight                           | O(log n)       | O(1)            | m*O(log n)         |
| Quick Union Height or Weight w/ Path Compression | High       | Array[elem] storing direct Root and Array[Root] storing (-ve)TreeHeight or (-ve)TreeNumberOfNodes | O(1)           | O(1)            | m*O(1)             |
