class Solution {
    public int maximumPopulation(int[][] logs) {
        int length = logs.length;
        if (length == 0) return 0;
        Arrays.sort(logs, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxPop, year = 0;
        pq.offer(logs[0][1]);
        maxPop=1; year=logs[0][0];
        for (int i=1; i < length; i++) {
            int current_start = logs[i][0];
            int current_end = logs[i][1];
            pq.offer(current_end);
            if (current_start >= pq.peek()) {
                pq.poll();
            }
            if (pq.size() > maxPop) {
                maxPop = pq.size();
                year = current_start;
            }
        }
        return year;
    }
}