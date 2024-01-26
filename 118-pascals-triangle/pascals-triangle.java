class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) return result;
        numRows -= 1;
        while(numRows-- > 0) {
            List<Integer> last = result.get(result.size() - 1);
            List<Integer> new_list = new ArrayList<>();
            new_list.add(1);
            int index = 0;
            while(index < last.size() - 1) {
                new_list.add(last.get(index) + last.get(index + 1));
                index += 1;
            }
            new_list.add(1);
            result.add(new_list);
        }
        return result;
    }
}