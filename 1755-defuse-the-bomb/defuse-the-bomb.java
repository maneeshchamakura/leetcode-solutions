class Solution {
    public int[] decrypt(int[] code, int k) {
        // find the prefix sum
        int n = code.length;
        int[] prefix = new int[n];
        prefix[0] = code[0];
        int[] result = new int[n];
        for (int i=1; i<n; i++) {
            prefix[i] = code[i] + prefix[i-1];
        }
        if (k == 0) return result;
        if (k < 0) {
            k *= -1;
            for (int i=0; i<n; i++) {
                int temp = 0;
                int possible_left = i;
                if (k > possible_left) {
                    if (possible_left > 0) {
                        temp += prefix[i];
                        temp -= code[i];
                    }
                    // wrap around length
                    int temp_k = k - i;
                    // add k element from the right side
                    temp += prefix[n-1] - prefix[n-temp_k];
                    temp += code[n-temp_k];
                } else {
                    // no need to wrap around
                    temp += prefix[i] - prefix[i-k];
                    temp += code[i-k];
                    temp -= code[i];
                }
                result[i] = temp;
            }
        } else {
           for (int i=0; i<n; i++) {
               int temp = 0;
               int possible_right = n - i - 1;
               if (k > possible_right) {
                   if (possible_right > 0) {
                       temp += prefix[n-1] - prefix[i];
                   }
                   int temp_k = k - possible_right;
                   temp += prefix[temp_k-1];
               } else {
                   temp += prefix[i+k] - prefix[i];
               }
               result[i] = temp;
           }           
        }
        return result;
    }
}