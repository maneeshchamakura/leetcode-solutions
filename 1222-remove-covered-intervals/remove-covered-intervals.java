class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int val = Integer.compare(a[0], b[0]);
            if (val == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return val;
        });
        int count = 1;
        int x=intervals[0][0], y=intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            int currentX = intervals[i][0], currentY = intervals[i][1];
            if (currentX >= x && currentY <= y) continue;
            count++;
            x = intervals[i][0];
            y = intervals[i][1];
        }
        return count;
    }
}