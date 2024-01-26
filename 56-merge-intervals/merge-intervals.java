class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[][] result = new int[n][2];
        int resultIndex = 0;
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        for (int i=1; i<n; i++) {
            int currentStart = intervals[i][0], currentEnd = intervals[i][1];
            int resultStart = result[resultIndex][0], resultEnd = result[resultIndex][1];
            if (resultEnd >= currentStart) {
                int temp = Math.max(resultEnd, currentEnd);
                result[resultIndex][1] = temp;
            } else {
                resultIndex++;
                result[resultIndex][0] = currentStart;
                result[resultIndex][1] = currentEnd;
            }
        }
        return Arrays.copyOfRange(result, 0, resultIndex+1);
    }
}