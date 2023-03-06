package year2k21.common.pattern.binaryoperation;

public class CheckIfPowerOfFour {

    /**
     * Power oF 4 means => If only one 1-Bit there AND 1-Bit is there at only odd place
     *
     * 0x55555555 = 1010101....10101
     */
    boolean isPowerOfFour(int n) {
        //(n & (n-1)) == 0 , If Clearing last 1 bit makes the number ZERO, then number has only one 1-Bit
        return (n & (n-1)) == 0 && ((n & 0x55555555) == 0);
    }
}
