class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) return -1;
            else if (a[1] > b[1]) return 1;
            else {
                return Integer.compare(a[0], b[0]);
            }
        });
        Map<Integer, Integer> index_map = new HashMap<>();
        for(int i=0; i<arr2.length; i++) {
            index_map.put(arr2[i], i);
        }
        for(int i=0; i<arr1.length; i++) {
            int[] temp = new int[]{arr1[i], index_map.getOrDefault(arr1[i], 1000)};
            // System.out.println(Arrays.toString(temp));
            minHeap.offer(temp);
        }
        int[] result = new int[arr1.length];
        for(int i=0; i<arr1.length; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}