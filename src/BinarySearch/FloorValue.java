package BinarySearch;

public class FloorValue {
    //floor value using binary search with duplicate values
    public int floorValue(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (arr[mid] > key) {
            return mid - 1;
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        FloorValue fv = new FloorValue();
        int[] arr = {1,2,3,4,5,5,7,8,9,10};
        System.out.println(fv.floorValue(arr, 5));
    }
}
