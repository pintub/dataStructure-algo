package year2k21.common.pattern.binaryoperation;

/**
 *
 * My Thought was to iterate and count 1-Bits using {@link Count1Bits}
 *
 * Improvised version Below From LeetCode
 * ======================================
 *
* num :          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * countOf1Bit : 0 1 1 2 1 2 2 3 1 2  2  3  2  3  3  4
 * 
 * BullShit Theory(Notice above) :
 *      countOf1Bit(OddNum) = countOf1Bit(OddNum / 2) + 1
 *      countOf1Bit(EvenNum) = countOf1Bit(EvenNum / 2)
 */
public class Count1BitsFrom0ToN338 {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i=1; i<=num; i++) {
            if((i % 2) == 0) {
                result[i] = result[i >> 1];//Right-shift means i / 2
            } else {
                result[i] = result[i >> 1] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
