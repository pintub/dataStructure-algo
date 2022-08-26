### HEAP or PRIORITY-QUEUE

#### Basics
##### Heap Definition
- Complete Binary Tree (Refer Tree Doc)
- Max Heap means parent > Both children
##### Visual Representation vs Implementation 
- Visually uses Tree, But implementation uses an array 
- leftChildIndex = 2 * parentIndex + 1, rightChildIndex = 2 * parentIndex + 2, parentIndex = (anyChildIndex - 1) / 2
