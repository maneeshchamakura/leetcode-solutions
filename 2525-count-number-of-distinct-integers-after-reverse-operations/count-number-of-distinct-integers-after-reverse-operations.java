class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.stream(nums).mapToObj(a -> String.valueOf(a)).collect(Collectors.toList()));
        for(int num: nums) {
            String s = num + "";
            StringBuffer sb = new StringBuffer(s);
            int rev_num = Integer.parseInt(sb.reverse().toString());
            set.add(String.valueOf(rev_num));
        }
        return set.size();
    }
}