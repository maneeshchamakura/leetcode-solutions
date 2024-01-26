class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(target == 1) {
            if (edges.length == 0) return 1;
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            List<Integer> adjs = map.getOrDefault(u, new ArrayList<>());
            adjs.add(v);
            map.put(u, adjs);
            List<Integer> adjs_v = map.getOrDefault(v, new ArrayList<>());
            adjs_v.add(u);
            map.put(v, adjs_v);
        }
        List<Integer> path= new ArrayList<>();
        dfs(map, n, t, target, path, new HashSet<>());
        if (t < path.size() - 1) return 0;
        double prob = 1.0;
        double numerator = 1.0;
        double denominator = 1.0;
        for (int i=path.size() - 2; i > 0; i--) {
            int count = map.get(path.get(i)).size();
            denominator *= ((count - 1)*1.0);
        }
        denominator *= map.get(1).size();
        prob = prob / denominator;
        if (t > path.size() - 1 && map.get(target).size() == 1) {
            // frog keeps on hopping
            return prob;
        } else if (t > path.size() - 1) return 0;
        return prob;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, int n, int t, int target, List<Integer> path, Set<Integer> visited) {
        // base case later
        visited.add(target);
        path.add(target);
        if (target == 1) {
            return true;
        }
        for (int neighbor: map.get(target)) {
            if(visited.contains(neighbor)) continue;
            boolean found = dfs(map, n, t, neighbor, path, visited);
            if (found) return true;
        }
        visited.remove(target);
        path.remove(path.size() - 1);
        return false;
    }
}