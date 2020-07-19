public class Solution1281 {
    public int subtractProductAndSum(int n) {
        char[] charArray = ("" + n).toCharArray();
        int sum = 0,product = 1;
        for(char c : charArray){
            int num = Character.getNumericValue(c);
            sum += num;
            product *= num;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1281().subtractProductAndSum(4421));
    }
}
