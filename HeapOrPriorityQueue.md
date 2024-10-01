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
    2    
   /  \        ==> [2,4,3,6,7,4,5]    
  4    3  
 / \   / \
6   7  4  5
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
count of leaf nodes = ⌈n/2⌉, Non-leaf nodes = n - ⌈n/2⌉
##### Insertion & Deletion
Insertion always at the last level & filled left to right, whereas Deletion always deletes the Root.
##### Heapify Up/Down
- heapifyUp(element): For insert(element) at the end, it might violate the Heap constraints, so heapify up to put the inserted value at correct position
  - Works iff upper part of tree is already heapified
- heapifyDown(element): For delete(root) at the Root(i.e. replace last-most node value @root, reduce --countOfNodes), it might violate the Heap constraints, so heapify down.
  - Works iff lower part of tree is already heapified
  - :clown_face: Also `buildHeap(arr[])` uses heapifyDown() traversing bottom-up from 1st non-leaf to Root node(i.e, For 1st non-leaf node use above ⌈n/2⌉ formula), whereas `heapSort(arr[])` uses heapifyDown()  traversing top-down from Root to till End

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
- :bulb: 1.Search for element using any traversal O(n) 2.Then delete the founf element & replace with ".the last element of the bigger tree" & Heapifydown if necessary, O(logn)
##### :rocket: print elements less than given integer =k in Min Heap
- :bulb: Just w/ Tree recursive traversal
##### :rocket: Merge 2 Heaps
- :bulb: Use buildHeap() for linear time & set countOfNodes as well
##### :rocket: Find Kth smallest element in a unsorted Array
- :bulb:
  - Approach-1 : Using Min-Heap => buildHeap(arr[]) , Then deleteMin() k times, Time=O(nlogn + klogn) = O(n logn), Space=O(1)
  - Approach-2 : Using Max-Heap => buildHeap(arr[]) for 1st k elements, so top element is kth element till now.<br/> 
  Now traverse (k+1)th element onwards in the input array<br/>
  If input-array-element is less than max-heap-root, replace root and heapifyDown().<br/> 
  Finally top-most element of max-heap is the answer
    - Time Complexity : O(k logk) + O((n-k)logK) = O(nlogk)
  - Approach-3 : Quick Select[i.e. Quick sort with one-directional choice to find kth smallest or Largest]. [Must Read](https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60333/concise-java-solution-based-on-quick-select/?orderBy=most_votes)
##### :rocket: Find K frequent elements in a unsorted Array
- Approach-1 : Using numVsFrequencyMap & Heap. Using double-pass iteraton
- Approach-2 : Using numVsFrequencyMap & freqVsNumListMap. Fetch first k elements from freqVsNumListMap
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
 
##### :rocket: kth element in Sorted Arrays (KthSmallestElementInASortedMatrix378)
  - Improvision of Merge k Sorted list
  - Time = klogk
##### :rocket: Find K Pairs with Smallest Sums 373
  - Improvision of KthSmallestElementInASortedMatrix378
  - Time = klogk
    
##### :rocket: Median in steam of numbers
- :bulb: [Two Heap](Leetcode/src/main/java/year2k21/common/pattern/heap/two/Solution295.java)

##### Find Top k Projects before IPO of a company given profits[] and capital[] [Leetcode502](https://leetcode.com/problems/ipo/description/)
- :bulb: Two Heap

#### Tips
- Use buildHeap() wherever possible as it's O(n)
- Few questions has multiple solutions of O(nlogk) and O(klogn). O(klogn) is faster . Read Below which is even better.<br/>
  O(klogn) [Heap of size "n" and process "k" elememnts] > O(nlogk) [Heap of size "k" and process "n" elememnts] > o(nlogn)  
- Many times you will see Time complexity = O(klogn), Try converting it to O(klogk) by using Heap of k size
- If Median of stream of elements or in sliding window, Think of Two Heap

#### Heap Vs TreeSet
- Both has ordered items
- Heap 
  - Remove top element : O(logn)
  - `Remove non-root : O(n)`
  - `Search or contains() : O(n)`
  - Add element : O(logn)
  - build Heap : O(n), But for Java  it is O(nlogn) as it adds one by one
  - `iterator() -> Not ordered, But You can use peek() and poll() which is order`
- TreeSet (Uses Red-Black self-balanced Tree)
  - `Remove "Any" element : O(logn)`
  - Add element : O(logn)
  - `Search or contains() : O(logn)`
  - `iterator() -> Ordered`
- When TreeSet:
  - If remove any element is needed, Think of TreeSet
    - But TreeSet doesn't allow dups. So,if dups expected in input array, you can store index instead in TreeSet. Comparator should handle duplicate as well. `(Pair<Integer, Integer> pair) -> pair.left).thenComparingInt(pair -> pair.right)` 
  - When iterator() needed, Use TreeSet or Use PQ where you can use peek() and poll()
