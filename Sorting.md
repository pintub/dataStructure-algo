### SORTING 
- [Refer Problems in below order](./Practice/src/main/java/com/p2/sort)

#### Types
- Bubble 
- Selection
- Insertion
- Merge Sort
  - Recursion vs Divide n Conquer Gyan
    - How Time complexity= `nlogn`, T(n) = 2T(n/2) + θ(n), i.e. Merging happens only logn times & each merging is approx O(n).<br/> 
    This different from recursion tree where each node of tree does some computation, but in divide n conquer, Tree formed but each node does not do computation, rather merging node does computation
- Quick Sort
- Heap Sort
  - Also O(nlogn)
- Counting Sort
- Radix Sort
- Bucket Sort
- [Dutch Flag/Sort Colors](https://github.com/pintub/dataStructure-algo/blob/master/Leetcode/src/main/java/year2k21/common/pattern/sorting/SortColors75.java)

#### Term
- Stable Sorting : If order of two same keys in unSorted list are retained in output sorted list

#### Design Question
- Cloud storage has 10L records, how to sort given memory constraint(Can hold only 1L records)
  - [External Sorting, Distributed Sorting(Merge-sort on external files)](https://stackoverflow.com/a/2087671/2653389)
