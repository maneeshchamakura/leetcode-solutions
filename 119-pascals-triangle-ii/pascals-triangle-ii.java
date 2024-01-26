class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        for (int i=0; i<=rowIndex; i++) list.add(0);
        list.set(0, 1);
        rowIndex--;
        int i = 1;
        while (rowIndex >= 0) {
            list.set(i, 1);
            for (int j=i-1; j>0; j--) {
                int sum = list.get(j) + list.get(j-1);
                list.set(j, sum);
            }
            i++;
            rowIndex--;
        }
        return list;
    }
}