class Solution {
    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        for (int i=0; i<n; i++) {
            chars[i] = (char)('1' + i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i=1; i<fact.length; i++) {
            fact[i] = (i + 1)* fact[i-1];
        }
        for (int i=0; i<n-1; i++) {
            int num = fact[n-i-2];
            int blockNum = (k % num == 0) ? k/num: k/num + 1;
            int prev = (blockNum - 1)*num;
            k = k - prev;
            swap(chars, i, i+blockNum - 1);
            Arrays.sort(chars, i+1, n);
        }
        return new String(chars);
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}