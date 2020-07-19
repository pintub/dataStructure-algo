public class Solution1309 {
    public String freqAlphabets(String s) {
        StringBuilder output = new StringBuilder();
        int size = s.length();
        for(int count = 0; count < size ; count++){
            char c = s.charAt(count);
            if((count+2) < size && (c == '1' || c == '2') &&
                    ( s.charAt(count+2) == '#')){
                output.append(numToStr(Character.getNumericValue(c)*10 +
                        Character.getNumericValue(s.charAt(count+1))));
                count += 2;
            } else {
                output.append(numToStr(Character.getNumericValue(c)));
            }

        }
        return output.toString();
    }

    private char numToStr(int num) {
        return (char) (num + 96);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1309().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
