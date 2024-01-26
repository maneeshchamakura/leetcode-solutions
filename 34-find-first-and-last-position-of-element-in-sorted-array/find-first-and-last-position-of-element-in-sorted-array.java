class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = findFirstOccurence(nums, target);
        arr[1] = findLastOccurence(nums, target);
        return arr;
    }
     static int findFirstOccurence(int[] a, int key){
        int first = 0;
        int last = a.length - 1;
        int mid = (first + (last - first)/2);
        while(first <= last){
            mid = first + (last - first)/2;
            if(a[first] == key){
                return first;
            }
            if(a[mid] == key){
                last = mid;
            } else if(a[mid] > key){
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }

    static int findLastOccurence(int[] a, int key){
        int first = 0;
        int last = a.length - 1;
        while(first <= last){
            int mid = (first + (last - first)/2);
            if(a[last] == key){
                return last;
            }
            if(mid == first && a[mid] == key )return mid;
            if(a[mid] == key){
                first = mid;
            } else if(a[mid] < key){
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

}