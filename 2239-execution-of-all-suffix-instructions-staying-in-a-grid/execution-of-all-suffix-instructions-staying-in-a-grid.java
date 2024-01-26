class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int rows= n, cols = n;
        int res_len = s.length();
        int[] result = new int[res_len];
        for(int i=0; i<res_len; i++) {
            int row = startPos[0], col = startPos[1];
            int count = 0;
            int cur_index = i;
            while (cur_index < s.length()) {               
                char current_direction = s.charAt(cur_index++);
                if (current_direction == 'L') {
                    col--;
                } else if (current_direction == 'R') {
                    col++;
                } else if (current_direction == 'U') {
                    row--;
                } else if (current_direction == 'D') {
                    row++;
                }
                if (row >= 0 && row < rows && col >=0 && col < cols) {
                    count++;
                } else {
                    break;
                }
            }
            result[i] = count;
        }
        return result;
    }
}