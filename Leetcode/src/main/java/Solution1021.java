public class Solution1021 {

    //StringBuilder
    public String removeOuterParentheses(String S) {
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                ++counter;
                if(counter != 1){
                    output.append('(');
                }
            } else {
                --counter;
                if(counter != 0){
                    output.append(')');
                }
            }
        }
        return output.toString();
    }

    //String
    public String removeOuterParenthesesV2(String S) {
        String output = "";
        int counter = 0;
        int subStringStartIndex = 0;
        for(int count =0; count < S.length(); count++){
            if(S.charAt(count) == '('){
                ++counter;
            }
            if(S.charAt(count) == ')'){
                --counter;
                if(counter == 0){
                    output = output + S.substring(subStringStartIndex+1, count);
                    subStringStartIndex = count+1;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1021().removeOuterParentheses("(()())(())(()(()))"));
    }
}
