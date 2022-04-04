package BinarySearch;

public class BinarySearch {
    public void search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                System.out.println("Found at " + mid);
                break;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low > high) {
            System.out.println("Not found");
        }
    }
   // rotated array searc
    public void rotatedSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                System.out.println("Found at " + mid);
                break;
            }
            else if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
    }
}
