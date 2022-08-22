package year2k21.common.pattern.binary;

public class CheckIfPowerOfFour {

    /**
     * If only one 1-Bit there AND 1-Bit is there at only odd place
     * 0x55555555 = 1010101....10101
     */
    boolean isPowerOfFour(int n) {
        return (n & (n-1)) == 0 && ((n & 0x55555555) == 0);
    }
}
