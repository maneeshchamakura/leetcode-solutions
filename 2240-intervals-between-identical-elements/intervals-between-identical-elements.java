class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int element = arr[i];
            List<Integer> alist = map.computeIfAbsent(element, k -> new ArrayList<>());
            alist.add(i);
            map.put(element, alist);
        }
        long[] ans = new long[n];
        for(int key: map.keySet()) {
            List<Integer> alist = map.get(key);
            long[] result = get_array(alist.stream().mapToInt(k->(int)k).toArray());
            int i = 0;
            for(int index: alist) {
                ans[index] = result[i++];
            }
        }
        return ans;
    }
    
    public long[] get_array(int[] arr) {
        int n = arr.length;
        long[][] left_ans = new long[n][2];
        long[][] right_ans = new long[n][2];
        // from left
        for(int i=1; i<n; i++) {
            long val = left_ans[i-1][0], count = left_ans[i-1][1];
            long diff = Math.abs(arr[i] - arr[i-1]);
            long current_ans = diff;
            current_ans += val + diff*count;
            left_ans[i][1] = count + 1;
            left_ans[i][0] = current_ans;
        }
        // from right
        for (int i=n-2; i >=0; i--) {
            long val = right_ans[i+1][0], count = right_ans[i+1][1];
            long diff = Math.abs(arr[i] - arr[i+1]);
            long current_ans = diff;
            current_ans += val + diff*count;
            right_ans[i][1] = count + 1;
            right_ans[i][0] = current_ans;       
        }
        long[] result = new long[n];
        for(int i=0; i<n; i++) {
            result[i] = left_ans[i][0] + right_ans[i][0];
        }
        return result;
    }
}