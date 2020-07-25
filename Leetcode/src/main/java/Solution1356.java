import java.util.*;

/**
 * Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 *
 * Return the sorted array.
 */
public class Solution1356 {

    //TreeSet to have sorted numbers
    public int[] sortByBitsV2(int[] arr) {
        int[] output = new int[arr.length];
        Map<Integer, Integer> numFreq = new HashMap();
        Set<Integer>[] binaryOneFreq = new TreeSet[14];//Index binaryOneCount, Value ->SortedList of numbers having that binaryOneCount
        //As number range is 1 to 10^4 , and 1064 can have max 14 binary digits

        for(int i : arr){//O(n)
            int binaryOnesCount = getBinaryOnes(i);
            Set<Integer> set = binaryOneFreq[binaryOnesCount];
            if(set == null) {
                set = new TreeSet();
                binaryOneFreq[binaryOnesCount] = set;
            }
            set.add(i);
            Integer mapCount = numFreq.get(i);
            numFreq.put(i, mapCount == null ? 1 : mapCount+1);
        }

        int outputCounter = 0;
        for(Set<Integer> set : binaryOneFreq){//O(14)
            if(set == null){
                continue;
            }
            for(int num : set) {//O(n/14)
                for(int count = 1; count <= numFreq.get(num); count++){
                    output[outputCounter] = num;
                    ++outputCounter;
                }
            }
        }

        return output;
    }

    //Use Integer.bitCount(i) instead
    private int getBinaryOnes(int num) {
        int count = 0;
        while(num != 0) {
            if(num % 2 == 1){
                ++count;
            }
            num /= 2;
        }
        return count;
    }

    //List and Array.sort for sorting
    public int[] sortByBitsV3(int[] arr) {
        int[] output = new int[arr.length];
        List<Integer>[] binaryOneFreq = new ArrayList[14];//Index binaryOneCount, Value ->SortedList of numbers having that binaryOneCount
        //As number range is 1 to 10^4 , and 1064 can have max 14 binary digits

        for(int i : arr){//O(n)
            int binaryOnesCount = Integer.bitCount(i);
            List<Integer> list = binaryOneFreq[binaryOnesCount];
            if(list == null) {
                list = new ArrayList();
                binaryOneFreq[binaryOnesCount] = list;
            }
            list.add(i);
        }

        int outputCounter = 0;
        for(List<Integer> list : binaryOneFreq){//O(14)
            if(list == null){
                continue;
            }
            Collections.sort(list);//O(n/14log(n/14))
            for(int num : list) {//O(n/14)
                output[outputCounter] = num;
                ++outputCounter;
            }
        }

        return output;
    }

    //Arrays.sort and comparator
    public int[] sortByBitsV4(int[] arr) {
        Integer[] arrCopy = new Integer[arr.length];
        for(int count = 0; count < arr.length; count++){
            arrCopy[count] = arr[count];
        }
        Arrays.sort(arrCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = Integer.compare(Integer.bitCount(o1), Integer.bitCount(o2));
                if(compare == 0){
                    return Integer.compare(o1, o2);
                } else {
                    return compare;
                }
            }
        });
        for(int count = 0; count < arr.length; count++){
            arr[count] = arrCopy[count];
        }

        return arr;
    }

    //Using Quick sort ,Has BUGS
    @Deprecated
    public int[] sortByBits(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quicksort(int[] arr, int low, int high) {
        if(low >= high){
            return ;
        }

        int pivotIndex = (low + high) /2;
        int partitionIndex = partition(arr, pivotIndex, low, high);
        quicksort(arr, low, partitionIndex);
        quicksort(arr, partitionIndex+1, high);
    }

    private int partition(int[] arr, int pivotIndex, int low, int high) {
        if(low >= high){
            return high;
        }

        while(Integer.bitCount(arr[low]) < Integer.bitCount(arr[pivotIndex])
                || (Integer.bitCount(arr[low]) == Integer.bitCount(arr[pivotIndex]) &&
                        arr[low] < arr[pivotIndex])){
            ++low;
        }

        while(Integer.bitCount(arr[high]) > Integer.bitCount(arr[pivotIndex])
                || (Integer.bitCount(arr[high]) == Integer.bitCount(arr[pivotIndex]) &&
                arr[pivotIndex] < arr[high])){
            --high;
        }

        if(low < high) {
            Util.swap(arr, low, high);
        } else if(low == high){
            return low;
        }

        return partition(arr, pivotIndex, ++low, --high);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1356().sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
    }
}
