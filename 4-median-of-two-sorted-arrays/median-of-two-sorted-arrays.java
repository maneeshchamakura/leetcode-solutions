class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int X = nums1.length, Y=nums2.length;
        int low=0, high=X;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (X+Y+1)/2 - partitionX;
            
            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX = (partitionX == X) ? Integer.MAX_VALUE: nums1[partitionX];
            
            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY = (partitionY == Y)? Integer.MAX_VALUE: nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((X+Y)% 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + (double)Math.min(minRightX, minRightY))/2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}