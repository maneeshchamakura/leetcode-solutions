class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // find 
        long result = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // add the first k elements to the Map<Integer, Integer> 
        long sum = 0;
        for(int i=0; i<k; i++) {
            sum += (nums[i]*1L);
            map.computeIfAbsent(nums[i], key-> 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        // check if size of map is k
        if (map.size() == k) {
            result = Math.max(result, sum);
        }
        for(int i=k; i < n; i++) {            
            // remove i - k value
            int left_most = nums[i-k];
            sum -= left_most*1L;
            // update the map
            map.put(left_most, map.get(left_most) - 1);
            // remove if count is 0
            if (map.get(left_most) == 0) {                
                map.remove(left_most);
            }
            // add this element
            int current = nums[i];
            // update sum
            sum += current*1L;
            // update map count
            map.computeIfAbsent(current, key->0);
            // add 1
            map.put(current, map.get(current) + 1);
            // check if size of map is k
            if (map.size() == k) {
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}