public class Solution1323 {

    //String way
    public int maximum69NumberV2 (int num) {
        char[] charArray = (""+num).toCharArray();
        int unitPlaceOfFirst6= 0;
        for(int count=0; count<charArray.length; count++){
            if(charArray[count] == '6'){
                unitPlaceOfFirst6 = charArray.length - count;
                num += 3 * Math.pow(10, unitPlaceOfFirst6-1);
                break;
            }
        }
        return num;
    }

    //Int way
    public int maximum69Number (int num) {
        int step = 1;
        int add = 0;
        int tmp = num;
        while (tmp > 0){
            int remainder = tmp%10;
            tmp /= 10;
            if(remainder == 6){
                add = 3*step;
            }
            step *= 10;
        }

        return num+add;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1323().maximum69Number(9996));
    }
}
