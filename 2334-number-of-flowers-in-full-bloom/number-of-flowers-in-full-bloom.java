class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        
        for(int i = 0;i < flowers.length;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1]+1;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        for(int i = 0;i < people.length;i++){
            int before = check(start,people[i]);
            int after = check(end,people[i]);

            ans[i] = before - after;
        }

        return ans;
    }

    private int check(int[] nums, int target){
        int lo = 0, hi = nums.length;

        while(lo < hi){
            int mid = lo + (hi-lo) / 2;

            if(nums[mid] <= target){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }

        return lo;
    }
}