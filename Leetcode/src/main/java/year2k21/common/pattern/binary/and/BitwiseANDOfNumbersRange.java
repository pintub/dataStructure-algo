package year2k21.common.pattern.binary.and;

/**
 * Question [a..b] -> Return AND of number in this range, inclusive
 * Intuition :
 *      [10010001, 10010010, 10010011, 10010100, 10010101, 10010110]
 *      Notice that all of above has 10010 common and rest 3 bits can be different
 *      During AND rest 3 bits will be ZERO, so answer is 10010-000
 *
 */
public class BitwiseANDOfNumbersRange {

    int rangeBitwiseAnd(int m, int n) {
        int countOfRestBits = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            countOfRestBits++;
        }
        return m<<countOfRestBits;
    }
}
