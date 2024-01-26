class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first_result = new ArrayList<>();
        List<Integer> second_result = new ArrayList<>();
        Set<Integer> first_set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> second_set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        for(int num: first_set) {
            if (!second_set.contains(num)) {
                first_result.add(num);
            }
        }
        // List<List<Integer>> second_result = new ArrayList<>();
        for(int num: second_set) {
            if (!first_set.contains(num)) {
                second_result.add(num);
            }
        }
        result.add(first_result);
        result.add(second_result);
        return result;
    }
}