class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<n; i++) {
            if (nums[i]>= 0 && nums[i] < n) continue;
            if (nums[i] >= n) nums[i] %= n;
            else {
                nums[i] *= -1;
                nums[i] %= n;
                nums[i] *= -1;
            }
        }
        for (int i=0; i<n; i++) {
            if (nums[i] == 0) {
                visited.add(i);
                continue;
            }
            if (!visited.contains(i)) {
                Set<Integer> visiting = new HashSet<>();
                int index = i;
                boolean isPositive = nums[index] > 0;
                visiting.add(index);
                while(true) {
                    index = (index + nums[index] + n)%n;
                    if (visiting.contains(index)) return true;
                    if (visited.contains(index)) break;
                    if (Math.abs(nums[index])%n == 0) {
                        visiting.add(index);break;
                    }                        
                    if (nums[index] < 0 && isPositive) break;
                    if (nums[index] > 0 && !isPositive) break;                        
                    visiting.add(index);
                }
                visited.addAll(visiting);
            }
        }
        return false;
    }
}