class Solution {
    static class Pair {
        int time;
        boolean start;
        int value;
        Pair(int time, boolean start, int value) {
            this.time = time;
            this.start = start;
            this.value = value;
        }
        public String toString() {
            return String.format("(%d, %s, %d)", this.time, this.start?"T": "F", this.value);
        }
    }
    public int maxTwoEvents(int[][] events) {
        List<Pair> alist = new ArrayList<>();
        int temp_max = 0;
        for(int[] event: events) {
            alist.add(new Pair(event[0] - 1, true, event[2]));
            alist.add(new Pair(event[1] - 1, false, event[2]));
            temp_max = Math.max(temp_max, event[2]);
        }
        Collections.sort(alist, (a, b) -> {
            int diff = Integer.compare(a.time, b.time);
            if (diff == 0) {
                if (a.start && !b.start) {
                    return 1;
                } else if (!a.start && b.start) {
                    return -1;
                }
                return Integer.compare(b.value, a.value);
            }
            return diff;
        });
        System.out.println(alist);
        int res = temp_max;
        int max_so_far = -1;
        // int[] first value has the closing range
        // int[] second value is the max_so_far
        List<int[]> left_ans = new ArrayList<>();
        for(Pair p: alist) {
            if (!p.start) {
                max_so_far = Math.max(max_so_far, p.value);
                left_ans.add(new int[]{p.time, max_so_far});
                continue;
            }
            if (max_so_far != -1) {
                int left_max = pick_max_less_than_start(left_ans, p.time);
                res = Math.max(res, left_max + p.value);
            }
        }
        return res;
    }

    int pick_max_less_than_start(List<int[]> left_ans, int target_time) {
        int res = -1;
        int low = 0;
        int n = left_ans.size();
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int[] arr = left_ans.get(mid);
            int time = arr[0], value = arr[1];
            if (time < target_time) {
                res = value;
                // found a pair
                // go towards right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}