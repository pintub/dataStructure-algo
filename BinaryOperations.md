### Binary operations [Refer leetCode post](https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)

#### Bit-Wise Operators
- OR(|), AND(&), XOR(^), Right-Shift(>>), Left-Shift(<<), Not(~)
- `Difference` Signed shift (>>) retains 1 at MSB for a -ve number, Unsigned shift (>>>) fills with ZERO
- Shift operators always fill `ZERO`(exception above point). If you want to left-shift with "1", use << and then add "1" recurringly .

#### Basics & Tips
- Java "int" is 4 bytes = 32 bits, represnted as `32 Signed Bit` . One bit(MSB) for sign, Other 31 bits for value . Range [-2^31, 2^32] <br/>
Binary of 2^32 - 1 = 011111..(30 times 1)...11 <br/>
Binary of 1 = 1s' complinent + 1 = 111(31 times 1)11110 + 1 = 11111(32 times 1)1 <br/>
`BE Careful & use this concept`
- Traversing bits of an integer is O(32), as  int is 32 bits. 32bits are <u>0-indexed</u>, starting from right to left, i.e. 0 to 31
- (-)ve number represented as 2s' compliment = (~x) + 1
- Conversion
  - Decimal to Binary
      - To get Count of 1 bits: Integer.bitCount(int) `Uses bit shifting`. [Checkout implementation](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/Count1Bits.java)
      - To get Binary Format: Integer.toBinaryString(int) `Also uses bit shifting. Think yourself How ??`
  - Binary String or Binary LL to Decimal `Use bit shifting`. [Checkout implementation](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/BinaryStringToDecimal.java)
  - Convert String to Binary format. Example: abe to 10011. Here String is Left to Right, but Binary is Right to Left 
- [Go through Basics](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/BinaryBasics.java)
<pre>
    public static void main(String[] args) {
        int a = 4; int b = 5;

        //Remove all 1 bits of a from b
        System.out.println(b & ~a);//Answer = 1

        //Set 4th bit(from right-side) of "a" as 1
        //Intuition : a | 0000000...00001000
        int bit = 3;//Question asks for 4th bit. Thus shift "1" only 3 times, so 1 becomes 1000(Notice,1 in 4th position) in binary
        System.out.println(a | (1 << bit));

        //Clear 4th bit(from right-side) of "a" as 0 "Or" Clear 4th bit of "a"
        //Intuition : a | 1111...11111110111
        bit = 3;
        System.out.println(a & ~(1 << bit));

        //Test if 4th(from right-side) bit is 1
        //Intuition : a & 1000 => If "0", 4th bit is 0. Else 1
        a = 9; bit = 3;
        System.out.println("Does 4th bit has 1:" + ((a & (1 << bit)) != 0 ? "true" : "false")); //True
        a=5; bit = 3;
        System.out.println("Does 4th bit has 1:" + ((a & (1 << bit)) != 0 ? "true" : "false")); //False

        //What is last bit in "a"
        //Intuition : a & 0001, If 1, Then 1. Else 0
        a = 4;
        System.out.println(a & 1);//0
        a = 5;
        System.out.println(a & 1);//1

        //Divide By 2
        a = 5;
        System.out.println(a >> 1 == 2);//2

        //Clear last 1-Bit from "a" & retain other bits, Example : a = 10011000, output = 10010000
        //Hard to Figure out, But HINT : To retain a bit you can do "&" operation on same bit or do "&" operation with 1. So, solution can be "either" 10011000 & 11110111 "or" 10011000 & 10010111 (Notice, 10010111 = 10011000 - 1)
        //Usages ? 1. Check if only one 1-bit is there 2.Counting # 1-Bits
        System.out.println(a & (a-1));

        //Retain last 1-Bit and Clear other bits to 0, i.e. Ulta of above
        //Remember
        //Usages ? To create Smart mask, keep last 1-Bit and others to 0. Refer SingleNumberIII260
        System.out.println(a & -a);//-a is 2s' compliment (i.e. 1's comliment + 1)

        //Convert String to Binary format. Example: "abe" to "10011".Here String is Left to Right, but Binary is Right to Left
        //Intuition : Iterate characters and perform "OR" 1-Left-shifted. Remember the binary format is reversed
        String s = "abe";
        int result = 0;
        for(int count = 0; count < s.length(); count++) {
            result = result | (1 << s.charAt(count) - 'a');
        }
        System.out.println("Binary Representation:" + Integer.toBinaryString(result));

        //Count number of bits till 1st 1-Bit. Example 00000100011, count = 6
        //Intuition : Keep Shifting Right until number becomes "0"  
        a = 67;//00...000001000011
        int count = 0;
        while (a != 0) {
            count++;
            a = a >> 1; //a = a & (a-1) //This clears the last "1" bit & Retains the other bits
        }
        System.out.println("Count of Bits:" + count);

        //Which binary operations doesn't mutate the original number
        a = 7;
        System.out.println("AND with Same Number:" + ((a & a) == a));
        System.out.println("AND with 32 1 bits:" + ((a & ~0) == a));
        System.out.println("OR with 32 0 bits:" + ((a | 0) == a));
        System.out.println("XOR with ZERO:" + ((a ^ 0) == a));
    }
</pre>
- [Go through Other questions](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation)
- Solve w/ pen/paper, Find how to transform from input to desired output
- Create <u>Smart masks</u>, let's say only 4th bit should be 1 and others should be 0, Mask can be 0000000..0001000
- If you want to cancel Common numbers, Use XOR 
- If you want to check if any letters common between two strings, Use AND

#### Good Questions
- [Given array of strings, Find max product of 2 strings when both don't have common characters](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/MaximumProductOfWordLengths318.java)
- [Count number of 1 Bits Starting From "0" To "N"](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/Count1BitsFrom0ToN338.java)
- [Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/SingleNumberIII260.java)

#### Non-Topic Good Question
- [Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.](./Leetcode/src/main/java/year2k21/common/pattern/binaryoperation/MajorityElementBoyceMooreVoting.java)
