package year2k21.common.pattern.binary;

public class Basics {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;

        System.out.println(a | b);
        System.out.println(a & b);

        //Remove all 1 bits of b from a
        System.out.println(a & ~b);//Answer = 0

        //Set 4th bit(from right-side) of "a" as 1
        //Intuition : a | 1000
        int bit = 3;//Question asks for 4th bit. Thus shift "1" only 3 times, so 1 becomes 1000(Notice,1 in 4th position) in binary
        System.out.println(a | (1 << bit));

        //Set 4th bit(from right-side) of "a" as 0 "Or" CLear 4th bit of "a"
        //Intuition : a | 0111
        bit = 3;
        System.out.println(a | ~(1 << bit));

        //Test if 4th(from right-side) bit is 1
        //Intuition : a & 1000 => If 1, 3th bit is 1. Else 0
        a = 8;
        bit = 3;
        System.out.println((a & (1 << bit)) != 0 ? 1 : 0);

        //Extract last bit from "a"
        //Intuition : a & 0001
        a = 4;
        System.out.println(a & 1);
        a = 5;
        System.out.println(a & 1);

        //Clear last 1-Bit from "a", Example : a = 10011000, output = 10010000
        //Hard to Figure out, But HINT : To retain a bit you can do & operation on same bit or do & operation with 1. So, solution can be "either" 10011000 & 11110111 "or" 10011000 & 10010111 (Notice, 10010111 = 10011000 - 1)
        //Try to remember
        System.out.println(a & (a-1));

        //Retain last 1-Bit and mark other bits to 0
        //Remember
        System.out.println(a & -a);
    }
}
