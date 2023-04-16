package year2k21.common.pattern.recursionANDbacktracking.date12042023;

/**
 * Input = {3, 1, 2}
 * Output = [{}, {3}. {1}, {2}, {3,1}, {3,2}, {1,2}, {3,1,2}}
 *
 * Intuition : Check comments below
 */
public class PrintAllSubsequences {

    public void solve(String s) {
        solve(s, 1, "");
    }

    private void solve(String str, int strOneIndex, String prefix) {
        if(strOneIndex > str.length()) {
            System.out.println(prefix);
            return;
        }

        solve(str, strOneIndex + 1, prefix + str.charAt(strOneIndex - 1));//Including current char
        solve(str, strOneIndex + 1, prefix);//Excluding current char
    }

    public static void main(String[] args) {
        PrintAllSubsequences sol = new PrintAllSubsequences();
        sol.solve("3124");
    }

}
