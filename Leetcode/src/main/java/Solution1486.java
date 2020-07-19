public class Solution1486 {

    public int xorOperation(int n, int start) {
        int temp = start;
        for(int count = 1; count < n ; count++){
            start += 2;
            temp = temp ^ start;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1486().xorOperation(1, 7));
    }
}
