package year2k21.common.pattern.binary.or;

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
        System.out.println(new NearestSmallerLargestPowerOf2().largestPower(257) == 256);
        System.out.println(new NearestSmallerLargestPowerOf2().largestPower(19) == 16);
        System.out.println(new NearestSmallerLargestPowerOf2().largestPower(15) == 8);
    }
}
