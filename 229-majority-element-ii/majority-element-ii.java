class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0, count2=0;
        Integer candidate1=null, candidate2=null;
        int n = nums.length;
        for (int num: nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        count1=count2=0;
        for (int num: nums) {
            if (candidate1 != null && candidate1 == num) count1++;
            if (candidate2 != null && candidate2 == num) count2++;
        }
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);
        return result;
    }
}