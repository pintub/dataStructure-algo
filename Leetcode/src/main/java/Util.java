public final class Util {

    private Util(){

    }

    public static int[] createArray(int... values){
        return values;
    }

    public static void swap(int[] arr, int a, int b){//Try without Temp
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
