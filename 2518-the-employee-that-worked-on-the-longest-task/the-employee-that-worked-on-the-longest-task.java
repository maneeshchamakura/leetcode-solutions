class Solution {
    public int hardestWorker(int n, int[][] logs) {
        //List<Integer> time_taken = new ArrayList<>();
        int prev=0;
        int max_time = -1;
        int max_id = -1;
        // if (logs.len)
        for(int[] log: logs) {
            int current = log[1] - prev;
            // time_taken.add(current);
            if (max_time == -1) {
                max_time = log[1];
                max_id = log[0];
            }
            if (current > max_time) {
                max_time = current;
                max_id = log[0];
            } else if (current == max_time) {
                if (max_id > log[0]) {
                    max_id = log[0];
                }
            }
            prev = log[1];
        }
        return max_id;
    }
}