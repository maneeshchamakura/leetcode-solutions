class Solution {
    public static boolean circularArrayLoop(int[] nums) {
        int N = nums.length;
        for(int i=0; i<N; i++){
            if(checkCycle(nums, i)){
                return true;
            }
        }
        return false;
    }

    static boolean checkCycle(int[] a, int i){
        boolean isPositive = a[i] > 0;
        int n = a.length;
        boolean[] visited = new boolean[n];
        while(isPositive == (a[i]>0)){
            if(visited[i])return true;
            visited[i] = true;
            if(a[i]%n == 0)return false;
            if(a[i] > 0){
                i = (i + a[i]%n)%n;
            } else if(a[i] < 0){
                i = (i - Math.abs(a[i])%n + n)%n;
            }
        }
        return false;
    }

}