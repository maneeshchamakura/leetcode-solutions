class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // move the values from the nums2 array into a map 
        // where the key is the number and value is the list of indices
        // that has the value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            List<Integer> indices_list = map.getOrDefault(nums2[i], new ArrayList<>());
            indices_list.add(i);
            map.put(nums2[i], indices_list);
        }
        List<List<Integer>> matching_indices = new ArrayList<>();
        for (int num: nums1) {
            matching_indices.add(map.getOrDefault(num, new ArrayList<>()));
        }
        Map<String, Integer> mem = new HashMap<>();
        return process(matching_indices, -1, 0, mem);
    }

    public int process(List<List<Integer>> matching_indices, int prev, int index, Map<String, Integer> mem) {
        String key = prev + "$" + index;
        if (mem.containsKey(key)) return mem.get(key);        
        if (index == matching_indices.size()) return 0;
        List<Integer> current_list = matching_indices.get(index);
        int max = 0;
        for(int current_index: current_list) {
            // take this index into consideration
            // chose this index
            // this should only happen if the current_index is greater than the 
            // prev passed
            if (current_index > prev){
                int next_pre = process(matching_indices, current_index, index + 1, mem);
                max = Math.max(next_pre+1, max);
            }
        }
        // don't pick any values from the current list
        int next_pre = process(matching_indices, prev, index + 1, mem);
        if (next_pre > max) {
            max = next_pre;
        }
        mem.put(key, max);
        return max;
    }
}