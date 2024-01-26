class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
        Arrays.sort(people, (a, b) -> (a[0] == b[0]? a[1] - b[1]: b[0] - a[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] p: people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }
}