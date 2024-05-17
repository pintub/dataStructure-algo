package year2k21.common.pattern.binaryoperation;

public class BinaryBasics {

    public static void main(String[] args) {
        int a = 4; int b = 5;

        System.out.println(a | b);
        System.out.println(a & b);

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
        System.out.println(a & -a);//-a is 2s' compliment

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
            a = a >> 1;
        }
        System.out.println("Count of Bits:" + count);

        //Which binary operations doesn't mutate the original number
        a = 7;
        System.out.println("AND with Same Number:" + ((a & a) == a));//AND with Same Number
        //AND with 32 1s'
        System.out.println("XOR with ZERO:" + ((a ^ 0) == a));//XOR with 0
    }
}
