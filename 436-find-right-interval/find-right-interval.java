class Solution {
    static class Pair {
        int val, index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int findClosestStartTime(List<Pair> pairs, int k, int n) {
        // binary search to find the closest one
        int low=0, high=n-1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            Pair p = pairs.get(mid);
            if (p.val == k) {
                return p.index;
            }
            if (p.val > k) {
                res = p.index;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[]{};
        int n = intervals.length;
        List<Pair> pairs = new ArrayList<>();
        int ind = 0;
        for (int[] interval: intervals) {
            pairs.add(new Pair(interval[0], ind));
            ind++;
        }
        Collections.sort(pairs, (a, b) -> Integer.compare(a.val, b.val));
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int current_end = intervals[i][1];
            // find the start time closes to current_end
            result[i] = findClosestStartTime(pairs, current_end, n);
        }
        return result;
    }
}