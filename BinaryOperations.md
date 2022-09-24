### Binary operations [Refer leetCode post](https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)

#### Bit-Wise Operators
- OR(|), AND(&), XOR(^), Right-Shift(>>), Left-Shift(<<), Not(~)
- Shift operators always fill `ZERO`

#### Basics & Tips
- Traversing bits of an integer is O(32), as  int is 32 bits
- 32bits are 0-indexed, starting from right to left, i.e. 0 to 31
- Decimal to Binary
    - To get Count of 1 bits: Integer.bitCount(int) `Uses bit shifting` > Dividing By 2 and Iterating
    - To get Binary Format: Integer.toBinaryString(int) `Also uses bit shifting`
- [Go through Basics](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/BinaryBasics.java)
- [Go through Other questions](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation)
- Solve in pen/paper, find how to transform from input to desired output
- Create smart masks, let's say only 4th bit should be 1 and others should be 0, Mask can be 0000000..0001000
- If you want to cancel Common numbers or to Check if any letters common between two strings, Use XOR
