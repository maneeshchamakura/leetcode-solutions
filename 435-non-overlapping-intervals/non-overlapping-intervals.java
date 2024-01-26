class Solution {
    static class Interval {
        int startTime;
        int endTime;
        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        public String toString() {
            return "[" + startTime + ", " + endTime + "]";
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval: intervals) intervalList.add(new Interval(interval[0], interval[1]));
        // sort
        Collections.sort(intervalList, (a, b) -> Integer.compare(a.startTime, b.startTime));
        int last_included= 0;
        int count=0;
        for (int i=1; i<intervals.length; i++) {
            if (intervalList.get(i).startTime < intervalList.get(last_included).endTime) {
                // overlap                
                count++;
                // 
                if (intervalList.get(i).endTime < intervalList.get(last_included).endTime) {
                    last_included = i;
                }
            } else {
                // no overlap
                last_included = i;
            }
        }
        return count;
    }
    public boolean overlap(int s1, int e1, int s2, int e2) {
        if (e1 > s1 && e1 <= e2) {
            return true;
        }
        return false;
    }
}