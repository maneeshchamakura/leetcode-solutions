class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> alist = new ArrayList<>();
        int left = 0;
        int right = 0;
        int n1 = nums1.length, n2 = nums2.length;
        while (left < n1 && right < n2) {
            int id1 = nums1[left][0], cost1 = nums1[left][1];
            int id2 = nums2[right][0], cost2 = nums2[right][1];
            if (id1 == id2) {
                // increase left as long as you find the same id1
                // increase right as long as you find the same id2
                int sum = 0;
                // increase left
                while (left < n1 && nums1[left][0] == id1) {
                    sum += nums1[left][1];
                    left++;
                }
                // increase right
                while (right < n2 && nums2[right][0] == id2) {
                    sum += nums2[right][1];
                    right++;
                }
                alist.add(new int[]{id1, sum});
            } else if (id1 < id2) {
                alist.add(new int[]{id1, cost1});
                left++;
            } else {
                alist.add(new int[]{id2, cost2});
                right++;
            }
        }
        while (left < n1) {
            alist.add(nums1[left]);
            left++;
        }
        while (right < n2) {
            alist.add(nums2[right]);
            right++;
        }
        int n = alist.size();
        int[][] result = new int[n][2];
        for(int i=0; i<n; i++) {
            result[i] = alist.get(i);
        }
        return result;
    }
    
    // [22,2,5,26,28,8,4,11,12,17,11,3,19,29,19,7,24,12,22,5,8,22]
}