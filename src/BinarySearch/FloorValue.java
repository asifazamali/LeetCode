package BinarySearch;

import java.util.Arrays;

public class FloorValue {
    //floor value using binary search with duplicate values
    /*
        1, 2, 2, 3
     */
    public int floorValue(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;
        while(low <= high) {
            int mid = low + ((high - low) >>> 2);
            if(key <= arr[mid]){
               res = mid;
               high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    public static int minEltRotatedArray(int[] arr){
        /*
            5, 6, 7, 8, 0, 1, 2
         */
        int low  = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = low + ((high -low) >> 2);
            if(arr[low] <= arr[mid]){
                if(arr[low] <= arr[high]){
                    high = mid-1;
                }else {
                    low = mid +1;
                }
            }
        }
    }

    public static void main(String[] args) {
//        FloorValue fv = new FloorValue();
//        int[] arr = {1,1,1,1, 1, 1, 1, 1, 2, 2};
//        for(int i: arr) {
//            System.out.printf(i + " ");
//            System.out.println(fv.floorValue(arr, i));
//        }
        int[] arr = {5, 6, 7, 8};
        System.out.println(arr[minEltRotatedArray(arr)]);
        System.out.println(Arrays.binarySearch(arr, 6));
//        BinarySearch binarySearch = new BinarySearch();
//        for(int elt: arr) {
//            System.out.printf("elt " + elt + " ");
//            binarySearch.rotatedSearch(arr, elt);
//        }

    }
}
