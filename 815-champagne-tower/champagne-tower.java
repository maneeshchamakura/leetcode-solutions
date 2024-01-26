class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // brute force
        double[] arr1 = new double[1];
        double[] arr2 = new double[2];
        int temp_row= 0;
        arr1[0]= poured;
        while(true) {
            int n = arr1.length;
            arr2 = new double[n + 1];
            for(int i=0; i<n; i++) {
                double in_flow = arr1[i];
                if (in_flow > 1) {
                    // set the value to its maximum
                    arr1[i] = 1;
                    // overflows
                    double excess_split = (in_flow - 1)/2.0;
                    // left and right splits
                    int bottom_left_glass_index = i;
                    int bottom_right_glass_index = i+1;
                    arr2[bottom_left_glass_index] += excess_split;
                    arr2[bottom_right_glass_index] += excess_split;
                }
            }
            if (temp_row == query_row) {
                return arr1[query_glass];
            }
            // next row is the current row for the next iteration
            arr1 = arr2;
            temp_row++;
        }
    }
}