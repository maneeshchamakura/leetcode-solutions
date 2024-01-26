class Solution {
    public int minimumArrayLength(int[] nums) {
        // count of the mininum element
        int min_element = Collections.min(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int count = 0;
        for(int num: nums) {
            if (num == min_element) count++;
        }
        boolean optimal = false;
        for(int num: nums) {
            if (num != min_element) {
                if (num % min_element != 0) {
                    optimal = true;
                }
            }
        }
        if (optimal) return 1;
        return (count + 1)/2;
    }
}