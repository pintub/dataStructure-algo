import java.util.*;

public class Solution1122 {
    //Array as Map
    //Extra Space O(1001)
    //Memory = O(n1)+O(n2)+O(n1 * logn1)+O(n1)
    public int[] relativeSortArrayV2(int[] arr1, int[] arr2) {
        int[] arr2NumberIndexMap = new int[1001];//Range of arr2 is 0 to 1000, Extra Space O(1001)
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        for (int count = 0; count < arr2Length; count++) {//O(n2)
            arr2NumberIndexMap[arr2[count]] = count + 1;
        }
        Integer[] arr1Copy = new Integer[arr1Length];
        for (int count = 0; count < arr1Length; count++) {//O(n1)
            arr1Copy[count] = arr1[count];
        }
        Arrays.sort(arr1Copy, getComparatorV2(arr2NumberIndexMap));//O(n1logn1)
        for (int count = 0; count < arr1Length; count++) {//O(n1)
            arr1[count] = arr1Copy[count];
        }
        return arr1;
    }

    private Comparator getComparatorV2(final int[] array) {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                if (array[i1] == 0 && array[i2] == 0) {//Both not present in arr2, they will be shown in asc order in o/p
                    return Integer.compare(i1, i2);
                } else if (array[i1] == 0) {//If 1st number not present in arr2, 2nd number should be displayed before 1st number in o/p ,so return +ve number
                    return 1;
                } else if (array[i2] == 0) {//If 2nd number not present in arr2, 1st should be displayed before 2nd number in o/p ,so return -ve number
                    return -1;
                } else {
                    return Integer.compare(array[i1], array[i2]);//both numbers present in arr2
                }
            }
        };
    }

    //Hash Map
    public int[] relativeSortArrayV3(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        HashMap<Integer, Integer> arr2NumberIndexMap = new HashMap();
        for (int count = 0; count < arr2Length; count++) {//O(n2)
            arr2NumberIndexMap.put(arr2[count], count);
        }
        Integer[] arr1Copy = new Integer[arr1Length];
        for (int count = 0; count < arr1Length; count++) {//O(n1)
            arr1Copy[count] = arr1[count];
        }
        Arrays.sort(arr1Copy, getComparatorV3(arr2NumberIndexMap));//O(n1logn1)
        for (int count = 0; count < arr1Length; count++) {//O(n1)
            arr1[count] = arr1Copy[count];
        }
        return arr1;
    }

    private Comparator getComparatorV3(final HashMap<Integer, Integer> map) {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                if (map.get(i1) == null && map.get(i2) == null) {//Both not present in arr2, they will be shown in asc order in o/p
                    return Integer.compare(i1, i2);
                } else if (map.get(i1) == null) {//If 1st number not present in arr2, 2nd number should be displayed before 1st number in o/p ,so return +ve number
                    return 1;
                } else if (map.get(i2) == null) {//If 2nd number not present in arr2, 1st should be displayed before 2nd number in o/p ,so return -ve number
                    return -1;
                } else {
                    return Integer.compare(map.get(i1), map.get(i2));//both numbers present in arr2
                }
            }
        };
    }

    //Extra Space O(n1-n2)
    //Memory = O(n1)+O(n2)+O((n1-n2) * log(n1-n2))+O(n2)
    public int[] relativeSortArrayV4(int[] arr1, int[] arr2) {
        int[] numberCountMap = new int[1001];//Range of arr2 is 0 to 1000, Extra Space O(1001)
        List<Integer> arr1MinusArr2 = new ArrayList();//arr1 - arr2
        for (int i : arr2) {//O(n2)
            numberCountMap[i] = 1;
        }
        for (int i : arr1) {//O(n1)
            if (numberCountMap[i] == 0) {//Number not present in arr2, save in arr1MinusArr2
                arr1MinusArr2.add(i);
            } else {
                ++numberCountMap[i];
            }
        }
        Collections.sort(arr1MinusArr2);//O((n1-n2) * log(n1-n2))
        int outputCounter = 0;
        for (int i : arr2) {//O(n2)
            int numberCount = numberCountMap[i] - 1;//Taking count of number only in arr1
            for (int count = 1; count <= numberCount; count++) {
                arr1[outputCounter] = i;
                ++outputCounter;
            }
        }
        for (int i : arr1MinusArr2) {//O(n1-n2)
            arr1[outputCounter] = i;
            ++outputCounter;
        }

        return arr1;
    }

    //Leetcode best solution
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];//Extra Space O(1001)
        int[] res = new int[arr1.length];//Extra Space O(n1)
        for(int i=0; i<arr1.length; i++) {//O(n1)
            counts[arr1[i]]++;
        }
        int i=0;
        for(int j=0; j<arr2.length; j++) {//O(n2)
            for(int k=0; k<counts[arr2[j]]; k++) {
                res[i++] = arr2[j];
            }
            counts[arr2[j]] = 0;
        }
        for(int j=0; j<counts.length; j++) {//O(1001)
            if(counts[j]>0) {
                for(int k=0; k<counts[j]; k++) {
                    res[i++] = j;
                }
                counts[j] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
