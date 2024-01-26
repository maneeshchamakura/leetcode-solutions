class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;
        Map<Integer, Integer> nodeCost = new HashMap<>();
        for(int i=0; i<n; i++) {
            nodeCost.put(i, cost[i]);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            List<Integer> nbs = graph.computeIfAbsent(u, k -> new ArrayList<>());
            nbs.add(v);
            graph.put(u, nbs);
            nbs = graph.computeIfAbsent(v, k -> new ArrayList<>());
            nbs.add(u);
            graph.put(v, nbs);
        }
        long[] result = new long[n];
        Arrays.fill(result, 0l);
        dfs(0, graph, result, nodeCost, new HashSet<>());
        
        return result;
    }
    
    public List<Integer> dfs(int node, Map<Integer, List<Integer>> graph, long[] result, Map<Integer, Integer> cost,  Set<Integer> visited) {
        visited.add(node);
        List<Integer> current_ans = new ArrayList<>();
        current_ans.add(cost.get(node));
        for(int nb: graph.get(node)) {
            if (visited.contains(nb)) continue;
            List<Integer> nb_ans = dfs(nb, graph, result, cost, visited);
            current_ans.addAll(nb_ans);            
        }
        Collections.sort(current_ans);
        long ans;
        int n =current_ans.size();
        if (current_ans.size() >= 3) {
            long val1 = current_ans.get(0);
            val1 *= current_ans.get(1);
            long val2 = current_ans.get(n-2);
            val2 *= current_ans.get(n - 3);
            long temp = Math.max(0, Math.max(val1, val2)*current_ans.get(n-1));
            ans = temp;
        } else {
            ans = 1;
        }
        // List<Integer> ans = new ArrayList<>();        
        result[node] =  ans;
        if (current_ans.size() <= 5) return current_ans;
        return new ArrayList<>(Arrays.asList(
            current_ans.get(0),
            current_ans.get(1),
            current_ans.get(n-3),
            current_ans.get(n-2),
            current_ans.get(n-1)
        ));
    }
    
    public void add(List<Integer> alist, int new_num) {
        alist.add(new_num);
        Collections.sort(alist, Collections.reverseOrder());
        if (alist.size() > 3) {
            alist.remove(alist.size() - 1);
        }
    }
}