package year2k21.common.pattern.binarysearch.mergesort.variant;

/**
 * WHOAA!! I DID IT, Keep trying!!!!!!
 */
public class CountReversePair493 {

    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int firstPartPointer = low;
        for(int secondPartPointer = mid + 1; secondPartPointer <= high; secondPartPointer++){
            long temp = 2L * nums[secondPartPointer];
            while (firstPartPointer <= mid && nums[firstPartPointer] <= temp) {
                firstPartPointer++;
            }

            count += (firstPartPointer > mid) ? 0 : (mid - firstPartPointer + 1);
        }

        mergeTwoSortedArrays(nums, low, mid, high);
    }

    public static void mergeTwoSortedArrays(int[] nums, int low, int mid, int high) {
        int firstPartPointer = low;
        int secondPartPointer = mid + 1;
        int[] temp = new int[high - low + 1];//Auxiliary space
        int tempCounter = 0;

        while (firstPartPointer <= mid && secondPartPointer <= high) {
            if(nums[firstPartPointer] <= nums[secondPartPointer]) {
                temp[tempCounter++] = nums[firstPartPointer];
                firstPartPointer++;
            } else {
                temp[tempCounter++] = nums[secondPartPointer];
                secondPartPointer++;
            }
        }

        while (firstPartPointer <= mid){
            temp[tempCounter++] = nums[firstPartPointer];
            firstPartPointer++;
        }

        while (secondPartPointer <= high){
            temp[tempCounter++] = nums[secondPartPointer];
            secondPartPointer++;
        }

        int originalArrayCounter = low;
        for(int num : temp) {
            nums[originalArrayCounter++] = num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountReversePair493().reversePairs(new int[]{1,3,2,3,1}));//2
        System.out.println(new CountReversePair493().reversePairs(new int[]{2,4,3,5,1}) == 3);
        System.out.println(new CountReversePair493().reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}) == 0);
    }
}
