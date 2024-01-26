class Solution {
    int[] parent;
    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int root1 = find(u);
        int root2 = find(v);
        parent[root2] = root1;
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        parent = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, List<Integer>> valuesToNode = new HashMap<>();
        for(int i=0; i<n; i++) {
            int val = vals[i];
            adj.add(new ArrayList<>());
            parent[i] = i;
            valuesToNode.computeIfAbsent(val, k -> new ArrayList<>()).add(i);            
        }
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for(int val: valuesToNode.keySet().stream().sorted().toList()) {
            for(int node: valuesToNode.get(val)) {
                if (visited.contains(node)) continue;
                visited.add(node);
                mergeComponents(adj, node, visited, vals);
            }
            Map<Integer, Integer> rootCost = new HashMap<>();
            for(int current: valuesToNode.get(val)) {
                rootCost.put(find(current), rootCost.getOrDefault(find(current) , 0) + 1);
            }
            for (int count: rootCost.values()) {
                result += (count*(count + 1))/2;
            }
        }
        return result;
    }

    public void mergeComponents(List<List<Integer>> adj, int node, Set<Integer> visited, int[] vals) {
        for(int neighbor: adj.get(node)) {
            if (vals[neighbor] > vals[node]) continue;
            union(neighbor, node);
            if (visited.contains(neighbor)) continue;
            visited.add(neighbor);
            mergeComponents(adj, neighbor, visited, vals);
        }
    }
}