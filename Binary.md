### Binary operations [Refer leetCode post](https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)

#### Bit-Wise Operators
- OR(|), AND(&), XOR(^), Right-Shift(>>), Left-Shift(<<), Not(~)

#### Basics
- Traversing bits of an integer is O(32) as  int is 32 bits
- Decimal to Binary
    - To get Count of 1 bits: Integer.bitCount(int) `Uses bit shifting` > Dividing By 2 and Iterating
    - To get Binary Format: Integer.toBinaryString(int) `Again uses bit shifting`
- [Go through Basics class](./Leetcode/src/main/java/year2k21/common/pattern/binary/Basics.java)
- Go through Other questions
- Solve in pen/paper, find how to transform from input to desired output
- Create smart masks, let's say only 4th bit should be 1 and others should be 0, Mask can be 0000000..0001000
- If you want to cancel Common numbers or Check if any letters between two strings, Use XOR
