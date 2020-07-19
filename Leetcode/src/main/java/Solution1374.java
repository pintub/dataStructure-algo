public class Solution1374 {
    public String generateTheString(int n) {
        StringBuilder output = new StringBuilder();
        for (int count = 1 ; count <= n - 1 ; count++){
            output.append('a');
        }
        output.append((n % 2 == 0) ? 'b' : 'a');
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1374().generateTheString(5));
    }
}
