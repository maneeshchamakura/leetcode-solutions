class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row_order = build_topo_sort(rowConditions, k);
        List<Integer> col_order = build_topo_sort(colConditions, k);
        if (row_order.size() < k || col_order.size() < k) return new int[0][0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<k; i++) {
            map.put(col_order.get(i), i);
        }
        int[][] ans = new int[k][k];
        for (int i=0; i<k; i++) {
            ans[i][map.get(row_order.get(i))] = row_order.get(i);
        }
        return ans;
    }
    
    public List<Integer> build_topo_sort(int[][] edges, int k) {
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] deg = new int[k+1];
        for (int i=0; i<=k; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            // directed edge from u -> v
            graph.get(u).add(v);
            // update in degree of v
            deg[v]++;
        }
        // start with in degree of zero
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i <= k; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for(int neighbor: graph.get(node)) {
                --deg[neighbor];
                if (deg[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return order;
    }
}