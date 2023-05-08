#### New Concepts
- [LRU Cache Implementation in O(1)](./Leetcode/src/main/java/com/p2/random/topinterviewques/LRUCache.java)
  - [Use `LinkedHashMap`](https://medium.com/@greekykhs/how-linkedhashmap-works-internally-in-java-409846a4f08)
  - It uses 2 DS (HashMap and Double LL), Use same object in both DS
- Get Random number From Array or List
  - `int randomIndex = (int)(Math.random() * arraySize); return arr[randomIndex];` : Math.random() returns a value between (0,1)