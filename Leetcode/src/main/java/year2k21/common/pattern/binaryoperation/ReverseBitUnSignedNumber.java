package year2k21.common.pattern.binaryoperation;

public class ReverseBitUnSignedNumber {

    //101(5) becomes 010(2)
    //intuition : Answer => Input XOR all-1-number-of-correct-length(Here 000....00111)
    private int reverseBits(int num) {

        if(num == 0)
            return 1;
        if(num == 1)
            return 0;

        int temp = num >> 1;
        int xorNum = 1;
        while (temp != 0) {
            xorNum = xorNum << 1;
            xorNum += 1;
            temp = temp >> 1;
        }

        return num ^ xorNum;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBitUnSignedNumber().reverseBits(5) == 2);
        System.out.println(Integer.toBinaryString(0xaaaaaaaa));
    }
}
