package year2k21.common.pattern.binaryoperation.and;

/**
 * Question [a..b] -> Return AND of number in this range, inclusive
 * Intuition :
 *      [10010001, 10010010, 10010011, 10010100, 10010101, 10010110]
 *      Notice that all of above has 10010 common and rest 3 bits can be different
 *      During AND rest 3 bits will be ZERO, so answer is 10010-000
 *
 *      So find the count of bit which change and left shift
 *
 */
public class BitwiseANDOfNumbersRange {

    int rangeBitwiseAnd(int m, int n) {
        int countOfBitsWhichChange = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            countOfBitsWhichChange++;
        }
        return m<<countOfBitsWhichChange;
    }
}
