package year2k21.common.pattern.dp.date21022023;

public class DecodeWays91 {

    public int numDecodings(String s) {
        int previousToPrevious = 0;
        int previous = 1;

        for(int i = 0; i <= s.length(); i++) {
            if(i == 0)
                continue;

            int count = 0;
            if(i-2 >=0) {
                int doubly = Integer.parseInt(s.substring(i - 2, i));
                if(doubly >= 10 && doubly <= 26) {
                    count += previousToPrevious;
                }
            }

            if(i-1 >=0) {
                int singly = Integer.parseInt(s.substring(i - 1, i));
                if(singly >= 1 && singly <= 9) {
                    count += previous;
                }
            }

            previousToPrevious = previous;
            previous = count;
        }

        return previous;
    }

    public static void main(String[] args) {
        DecodeWays91 sol = new DecodeWays91();
        System.out.println(sol.numDecodings("12") == 2);
        System.out.println(sol.numDecodings("06") == 0);
        System.out.println(sol.numDecodings("226") ==3);
    }
}
