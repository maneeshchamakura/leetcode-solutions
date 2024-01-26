class Solution {
    public int minGroups(int[][] intervals) {
        // put all intervals in treeset
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        for(int[] interval: intervals) {
            int start = interval[0], end = interval[1];
            treemap.computeIfAbsent(start, k -> new ArrayList<>());
            List<Integer> alist = treemap.get(start);
            alist.add(end);
        }
        int group_count = 0;
        while(!treemap.isEmpty()) {
            int start = treemap.firstKey();
            List<Integer> end_times = treemap.get(start);
            if (end_times == null) continue;
            // end_times
            for(int end_time: end_times) {
                if (end_times.contains(end_time)) {
                    group_count++;
                    // add possible intervals to this
                    int temp = end_time;
                    // find start time greater than temp
                    while(treemap.higherKey(temp) != null) {
                        // check if there any end_times here
                        int next_start_time = treemap.higherKey(temp);
                        int next_end_time = treemap.get(next_start_time).get(0);
                        treemap.get(next_start_time).remove(0);
                        if (treemap.get(next_start_time).isEmpty()) {
                            treemap.remove(next_start_time);
                        }
                        temp = next_end_time;
                    }
                }
            }
            //  remove the processed start time
            treemap.remove(start);
        }
        return group_count;
    }
}