class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int rows = nums.size();
        int cols = 0;
        for(List<Integer> alist: nums) cols = Math.max(cols, alist.size());
        // rows and cols
        // go along the diagonal starting from the left column
        List<List<Integer>> first_ans = new ArrayList<>();
        for(int i=0; i<rows; i++) first_ans.add(new ArrayList<>());
        List<List<Integer>> second_ans = new ArrayList<>();
        for(int i=1; i<cols; i++) second_ans.add(new ArrayList<>());
        
        for (int i=0; i<rows; i++) {
            List<Integer> current = nums.get(i);
            for (int j=0; j<current.size(); j++) {
                int val = nums.get(i).get(j);
                if (j == 0) {
                    first_ans.get(i).add(val);
                } else {
                    int res_row = i + j;
                    if (res_row >= rows) {
                        // second_ans add
                        second_ans.get(res_row - rows).add(val);
                    } else {
                        first_ans.get(res_row).add(val);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(List<Integer> alist: first_ans) {
            Collections.reverse(alist);
            result.addAll(alist);
        }
        for(List<Integer> alist: second_ans) {
            Collections.reverse(alist);
            result.addAll(alist);
        }
        return result.stream().mapToInt(a -> (int)a).toArray();
    }
    
    
    List<Integer> get_diagonal_values(int i, int j, int rows, int cols, List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        while(i >= 0 && i < rows && j >= 0 && j < cols) {
            List<Integer> current = nums.get(i);
            if (j < current.size()) {
                ans.add(current.get(j));
            }
            i--;
            j++;
        }
        return ans;
    }
    
}