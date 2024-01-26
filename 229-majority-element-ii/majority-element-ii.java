class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for(int num: nums) {
            if (count1 == 0 && num != candidate2) {
                count1 = 1;
                candidate1 = num;
            } else if (count2 == 0 && num != candidate1) {
                count2 = 1;
                candidate2 = num;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num: nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length/3) result.add(candidate1);
        if (count2 > nums.length/3) result.add(candidate2);
        return result;
    }    
}