public class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int output = 0;
        for(int count = 0 ; count < startTime.length; count++){
            if(startTime[count] <= queryTime && queryTime <= endTime[count]){
                ++output;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1450().busyStudent(Util.createArray(9,8,7,6,5,4,3,2,1)
                , Util.createArray(10,10,10,10,10,10,10,10,10), 5));
    }
}
