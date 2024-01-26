class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        List<Integer> indices = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if (nums[i] == 1) indices.add(i);
        }
        if (goal == 0) {
            if (indices.size() == 0)
            return (n*(n+1))/2;
            // handle for a mix of zeros and ones
            // and array has few ones
            int start = 0;
            while (start < nums.length) {
                int temp = start;
                // find zeros
                while (temp < nums.length && nums[temp] == 0) {
                    temp++;
                }
                int len = temp - start;
                res += (len*(len+1))/2;
                start = temp == start ? start + 1 : temp;
            }
            return res;
        }
        if (indices.size() < goal) return 0;
        int id1 = 0, id2 = goal - 1;
        int start = 0;
        while(id2 < indices.size()) {
            int first_index = indices.get(id1);
            int last_index = indices.get(id2);
            int temp_ans = 0;
            int left_val = first_index - start + 1;
            int right_val = (id2 == indices.size() - 1) ? n - last_index : indices.get(id2+1) - last_index;
            temp_ans += (left_val * right_val);
            start = first_index + 1;
            id1++;
            id2++;
            res += temp_ans;
        }
        return res;
    }
}