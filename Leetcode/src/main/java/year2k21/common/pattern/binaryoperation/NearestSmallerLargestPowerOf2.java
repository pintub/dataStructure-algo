package year2k21.common.pattern.binaryoperation;

public class NearestSmallerLargestPowerOf2 {

    long largestPower(long input) {
        if(input == 1)
            return 1;

        long ans = 1;
        input = input >> 1;

        while (input != 0) {
            ans = ans * 2;
            input = input >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        NearestSmallerLargestPowerOf2 sol = new NearestSmallerLargestPowerOf2();
        System.out.println(sol.largestPower(257) == 256);
        System.out.println(sol.largestPower(19) == 16);
        System.out.println(sol.largestPower(15) == 8);
    }
}
