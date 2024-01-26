class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        rowIndex--;
        int index = 1;
        while (rowIndex-- >= 0) {
            for (int i=index; i > 0; i--) {
                arr[i] = arr[i] + arr[i-1];
            }
            index++;            
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}