class Solution {
    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> intervals_list = new ArrayList<>();
        for(int[] interval: intervals) {
            intervals_list.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(intervals_list, (a, b) -> {
            int val = Integer.compare(a.start, b.start);
            if (val == 0) return Integer.compare(a.end, b.end);
            return val;
        });
        List<Interval> result = new ArrayList<>();
        int index = 0;
        int n = intervals_list.size();
        while (index < n) {
            int next = index + 1;
            int start = intervals_list.get(index).start;
            int end = intervals_list.get(index).end;
            while (next < n && intervals_list.get(next).start >= start &&
            intervals_list.get(next).start <= end) {
                end = Math.max(end, intervals_list.get(next).end);
                next++;
            }
            index = next;
            result.add(new Interval(start, end));
        }
        int[][] res_arr = new int[result.size()][2];
        int x = 0;
        for(int[] sub_arr: res_arr) {
            sub_arr[0] = result.get(x).start;
            sub_arr[1] = result.get(x).end;
            x++;
        }
        return res_arr;
    }
}