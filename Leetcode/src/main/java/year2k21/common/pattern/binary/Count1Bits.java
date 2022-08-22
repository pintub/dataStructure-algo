package year2k21.common.pattern.binary;

public class Count1Bits {

    int countOnes(int input) {
        int count = 0;

        //Keep removing last 1-Bit until input becomes ZERO
        while(input != 0) {
            input = input & (input-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
