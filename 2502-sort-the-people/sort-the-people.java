class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> alist = new ArrayList<>();
        for(int i=0; i<heights.length; i++) {
            alist.add(new int[]{i, heights[i]});
        }
        Collections.sort(alist, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        String[] sorted_names = new String[names.length];
        for (int i=0; i<sorted_names.length; i++) {
            sorted_names[i] = names[alist.get(i)[0]];
        }
        return sorted_names;
    }
}