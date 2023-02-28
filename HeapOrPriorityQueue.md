### HEAP or PRIORITY-QUEUE

#### Basics
##### Heap Definition
- Complete Binary Tree (Refer Tree Doc)
- Max Heap, Parent > Both children => Parent > Both Sub-Trees, As ">" operation is associative 
##### Visual Representation vs Implementation
- Visually uses Tree, But implementation uses an array. Why Array, Because heap operations needs lots of random access like getParentIndex(childIndex) and getChildIndex(parentIndex) 
- <pre> 
  Class Heap {
    int[] arr;
    int countOfNodes;//"V.V.Imp. property, Used in many operations"
  }
  </pre>
- Heap-Array is represented like level-order Traversal
<pre>
    11    
   /  \        ==> [11,12,13]    
  12    13  
</pre>
- leftChildIndex = 2 * parentIndex + 1, rightChildIndex = 2 * parentIndex + 2, parentIndex = (anyChildIndex - 1) / 2
##### Heap with Keys
If each node has 2 values, 1st value defines sorting order and 2nd value is just integer.
<pre> 
  Class Heap {
    Pair&lt;Key, Value&gt;[] arr;       //Node has Two info including key
    int countOfNodes;
  }
</pre>
##### Non-leaf vs Leaf nodes
Non-leaf nodes = [1, (countOfNodes - 1)/2], leaf nodes = [(countOfNodes - 1)/2 + 1, n]
##### Insertion & Deletion
Insertion always at the last level & filled left to right, whereas Deletion always deletes the Root.
##### Heapify Up/Down
- heapifyUp(element): For insert(element) at the end, it might violate the Heap constraints, so heapify up to put the inserted value at correct position
  - Works iff upper part of tree is already heapified
- heapifyDown(element): For delete(root) at the Root(i.e. replace last-most node value @root, reduce --countOfNodes), it might violate the Heap constraints, so heapify down.
  - Works iff lower part of tree is already heapified
  - :clown_face: Also `buildHeap(arr[])` uses heapifyDown() traversing bottom-up from 1st non-leaf to Root node(i.e, 1st non-leaf node = (countOfNodes-1)/2, whereas `heapSort(arr[])` uses heapifyDown()  traversing top-down from Root to till End

##### Java Heap
-MinHeap : Queue q = new PriorityQueue()
-MaxHeap : Queue q = new PriorityQueue((item1, item2) -> Integer.compare(item2, item1))

#### Problems
##### :rocket: Heap Problems
- insert(element) -> Uses heapifyUp()
- deleteMin() -> Delete root & move last-most element to root. Then use heapifyDown()
- buildHeap(unsortedArray[]) `Note` O(n) time complexity very useful in many problems
  - Thought which comes to mind: Keep adding elements using above insert(element) n times, Time complexity will be O(nlogn)
  - Optimized version: Use heapifyDown() Starting from level= height-1 -> 1, Time complexity will be O(n). This O(n) is tough to prove
- heapSort(unsortedArray[]) -> Creates a sorted Array
  - Step1: buildHeap(unsortedArray[]) O(n)
  - Step2 In Loop: Keep swapping root element/last-most element & heapifyDown(root) at lesser size tree. Lesser size tree can be achieved using "countOfNodes" property . This is inline sorting step & Time = O(nlogn).
  - <pre>
          1     Step1    2   Step2   3        (Step1 :1 & 3 swapped and heapifyDown(3) on array size =2)
        /  \     =>    /   \   =>   / \       (Step2 :3 & 2 swapped and heapifyDown(2) on array size =1)   
       2    3         3     1      2   1
      [1,2,3]         [2,3,1]     [3,2,1]
    </pre>
  - SO, HeapSort is also Time=O(nlogn) and space = O(1)
##### :rocket: Find max element in Min-Heap , Time= O(n/2) ≈ O(n)
- :bulb: max element in last level of Tree or 2nd half of array
##### :rocket: Delete a non-Root element in Heap
- :bulb: 1.Search for element using level Order O(n) 2.Then delete in decreased Tree size, O(logn)
##### :rocket: print elements less than given integer =k in Min Heap
- :bulb: Just w/ Tree recursive traversal
##### :rocket: Merge 2 Heaps
- :bulb: Use buildHeap() for linear time
##### :rocket: Find Kth smallest element in a unsorted Array
- :bulb:
  - Approach-1 : Using Min-Heap => buildHeap(arr[]) , Then deleteMin() k times, Time=O(klogn), Space=O(1)
  - Approach-2 : Using Max-Heap => buildHeap(arr[]) for 1st k elements, so top element is kth element till now.<br/> 
  Now traverse (k+1)th element onwards in the input array<br/>
  If input-array-element is less than max-heap-root, replace root and heapifyDown().<br/> 
  Finally top-most element of max-heap is the answer
    - Time Complexity : O(k) + O((n-k)logK) = O(nlogk)
##### :rocket: Find K frequent elements in a unsorted Array
- Approach-1 : Using Map & Heap. Using double passes
- Approach-2 : Using Map & Bucket Sort. O(n)
##### :rocket: Stack using Heap
- :bulb: Use insertion order as PQ key (Max Heap)
##### :rocket: Queue using Heap
- :bulb: Use insertion order as PQ key (Min Heap)
##### :rocket: Merge k Sorted list
- :bulb: 
  - Exactly same as merging 2 sorted list
  - Build Heap using 1st elements of each list, O(k)
  - If deleteMin() of above heap and find next of the list where this deleted-node exists and Repeat this
  - Time = O(#Elementlogk)
##### :rocket: Median in steam of numbers
- :bulb: [Two Heap](Leetcode/src/main/java/year2k21/common/pattern/heap/two/Solution295.java)

#### Tips
- Use buildHeap() wherever possible as it's O(n)
- Few questions has multiple solutions of O(nlogk) and O(klogn). O(klogn) is faster . Read Below which is even better.<br/>
  O(klogn) > O(nlogk) > o(nlogn)  
- Many times you will see Time complexity = O(klogn), Try converting it to O(klogk) by using Heap of k size
- If Median of stream of elements or in sliding window, Think of Two Heap

#### Heap Vs TreeSet
- Both has ordered items
- Heap 
  - Remove top element : O(logn)
  - Remove non-root : O(n)
  - Search or contains() : O(n)
  - Add element : O(logn)
  - build Heap : O(n), But for Java  it is O(nlogn) as it adds one by one
  - iterator() -> Not ordered, But You can use peek() and poll() which is order
- TreeSet (Uses Red-Black self-balanced Tree)
  - Remove "Any" element : O(logn)
  - Add element : O(logn)
  - Search or contains() : O(logn)
  - iterator() -> Ordered
- When TreeSet:
  - If remove any element is needed, Think of TreeSet
    - But TreeSet doesn't allow dups. So,if dups expected in input array, you can store index instead in TreeSet. Comparator should handle duplicate as well. `(Pair<Integer, Integer> pair) -> pair.left).thenComparingInt(pair -> pair.right)` 
  - When iterator() needed, Use TreeSet or w/PQ you can use peek() and poll()