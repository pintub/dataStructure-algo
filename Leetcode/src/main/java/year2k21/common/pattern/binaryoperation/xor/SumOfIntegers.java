package year2k21.common.pattern.binaryoperation.xor;

/**
 * Lengthy-Nice-Geek Explanation on WHY-THE_HECK below works
 * https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
 *
 * WHY "XOR" - W/O carry scenario, this itself will give answer
 * WHY "AND" and left-shift - "AND" gives which all are carry positions and left-shift because carry in added to left of where it is generated
 */
public class SumOfIntegers {

    int getSum(int a, int b) {
        return b==0 ? a :   getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}
