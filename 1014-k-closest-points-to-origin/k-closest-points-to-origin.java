class Solution {
    public int[][] kClosest(int[][] points, int K) {
        quickPartition(points, K);
        int[][] result = new int[K][2];
        for (int i=0; i<K; i++) {
            result[i] = points[i];
        }
        return result;
    }
    public void quickPartition(int[][] points, int K) {
        int start =0;
        int end =points.length - 1;
        while (start <= end) {
            int pIndex = partition(points, start, end);
            if (pIndex == K) return;
            if (pIndex > K) {
                end = pIndex - 1;
            } else {
                start = pIndex + 1;
            }
        }        
    }
    public int partition(int[][] points, int start, int end) {
        if (start == end) return start;
        int pivotVal = distance(points[end]);
        int index = start;
        for (int i=start; i<end; i++) {
            int currentDistance = distance(points[i]);
            if (currentDistance < pivotVal) {
                swap(points, i, index);
                index++;
            }
        }
        swap(points, index, end);
        return index;
    }
    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    public int distance(int[] arr) {
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
}