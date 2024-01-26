class Solution {
    public int longestConsecutive(int[] nums) {
        // put all numbers into a set
        // explore around the number
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int max = 0;
        for (int num: nums) {
            if (set.contains(num)){
                int count = 1;
                // go left
                int leftStart = num-1;
                while (set.contains(leftStart)){
                    set.remove(leftStart);
                    count++;
                    leftStart--;                    
                }
                // go right 
                int rightStart = num + 1;
                while (set.contains(rightStart)){
                    set.remove(rightStart);
                    count++;
                    rightStart++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}