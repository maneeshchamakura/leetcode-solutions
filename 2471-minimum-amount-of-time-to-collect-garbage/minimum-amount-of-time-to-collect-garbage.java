class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int result = 0;
        int n = garbage.length;
        int[] metal = new int[n];
        int[] glass = new int[n];
        int[] paper = new int[n];
        
        for (int i=0; i<n; i++) {
            String s= garbage[i];
            for(char c: s.toCharArray()) {
                if (c == 'M') {
                    metal[i]++;
                } else if (c == 'G') {
                    glass[i]++;
                } else {
                    paper[i]++;
                }
            }
        }
        
        int[] prefix_travel = new int[n];
        int sum = 0;
        for(int i=1; i<n; i++) {
            sum += travel[i-1];
            prefix_travel[i] = sum;
        }
        result += process(metal, prefix_travel);
        result += process(glass, prefix_travel);
        result += process(paper, prefix_travel);
        return result;
    }
    
    public int process(int[] arr, int[] travel) {
        int prev = 0;
        int n = arr.length;
        int result = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == 0) continue;
            int current = i;
            int distance = travel[i] - travel[prev];
            result += distance;
            result += arr[i];
            prev = current;
        }
        return result;
    }
}