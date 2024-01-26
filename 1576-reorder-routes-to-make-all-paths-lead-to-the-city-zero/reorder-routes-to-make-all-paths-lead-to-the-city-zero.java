class Solution {
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(-edge[0]);
        }
        dfs (graph, 0, -1);
        return res;
    } 
    public void dfs(List<List<Integer>> graph, int root, int parent) {
        for (int neighbor: graph.get(root)) {
            if (Math.abs(neighbor) == parent) continue;
            if (neighbor > 0) res++;
            dfs(graph, Math.abs(neighbor), root);
        }
    }
}