package year2k21.common.pattern.binarysearch.date06032023;

public class PeakIndexInMountainArray852 {

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {//with a sub-array of 3 elements, you should get answer
            int mid = (low + high) >> 1;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }

            if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {//Then search in other half
                low = mid;
            } else if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {//Then search in other half
                high = mid;
            }
        }

        //Can not reach here, arr is guaranteed to be a mountain array.
        return -1;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray852 sol = new PeakIndexInMountainArray852();
        System.out.println(sol.peakIndexInMountainArray(new int[]{1,2,1}) == 1);
        System.out.println(sol.peakIndexInMountainArray(new int[]{1,2,3,2,1}) == 2);
        System.out.println(sol.peakIndexInMountainArray(new int[]{1,9,4,3,2,1,0}) == 1);
        System.out.println(sol.peakIndexInMountainArray(new int[]{1,2,3,4,5,6,0}) == 5);
        System.out.println(sol.peakIndexInMountainArray(new int[]{0,1,2,3,4,3,2,0}) == 4);
    }
}
