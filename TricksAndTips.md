#### Tricks & Tips for Solving Questions

- Get Random number From Array or List
  - `int randomIndex = (int)(Math.random() * arraySize); return arr[randomIndex];` : Math.random() returns a value between (0,1)
- Division By 0 issue
  - 1 * 5 * 0. When traversing back, we would not know, what was the product before "0" got introduced. In other words, 0 causes information loss .
  - `Careful` while using Division operation
- Integer overflow issues
  - Might Cause stack overflow if you iterate through all possible ints from 0 to Inteter.MAX_VALUE
  - 2^31 -1 = Integer.MAX_VALUE ~ 2.1*10^9
- Array Copy
  - System.arrayCopy(src, srcIndex, dest, destIndex, arrLen)
- In TreeMap/PQ comparator, Use
  - Integer.compare(a,b)
  - aString.compareTo(bString)
- Prepend opeation
  - `StringBuilder`   sb.insert(position = 0, "abc")
  - `LinkedList` ll.add(index = 0, 1)
- Delete at end
  - `StringBuilder` sb.deleteAt(sb.length - 1)
  - `List` list.remove(list.size() - 1)
- Integer-char(example '1') to int
  - '1' - '0'
- How to sort related 2 Arrays together
  - Convert to 2d Array of pairs and Then sort
- Array of Collections & Collection of Array
  - List<Integer>[] arr = new  List<Integer>[5];
  - Queue<int[]> q = new LinkedList<>();
- 2D ArrayList to Array
  - resultList.toArray(new int[][]{})
