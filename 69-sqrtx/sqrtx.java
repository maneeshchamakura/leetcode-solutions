class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;      
        int low=1, high=x/2;
        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low)/2);
            if (mid == x/mid) {
                res = mid;
                break;
            } else if (mid < x/mid) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}