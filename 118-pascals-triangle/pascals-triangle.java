class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if (numRows == 1) return result;
        result.add(List.of(1,1));
        if (numRows == 2) return result;
        for(int i=2; i < numRows; i++) {
            List<Integer> prevRow = result.get(i-1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int j=0; j<prevRow.size() - 1; j++) {
                newList.add(prevRow.get(j) + prevRow.get(j+1));
            }
            newList.add(1);
            result.add(newList);
        }
        return result;
    }
}