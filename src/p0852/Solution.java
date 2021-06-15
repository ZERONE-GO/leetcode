package p0852;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if(mid <= 0 || mid >= arr.length-1) {
                break;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return -1;
    }

}
