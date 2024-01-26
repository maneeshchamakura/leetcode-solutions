class Solution {
    boolean secondApproach = true;
    public int makeConnected(int n, int[][] connections) {
        if (secondApproach) {
            return findConnected(n, connections);
        }
        List<List<Integer>> graph = createGraph(n, connections);
        Set<Integer> visited = new HashSet<>();
        int components = 0, extraEdges=0;
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                components++;
                int prev = visited.size();
                Set<String> edges = new HashSet<>();
                dfsUtil(i, graph, visited, edges);
                int nodesCount = (visited.size() - prev);
                int edgesCount = edges.size();
                if (edgesCount >= nodesCount) {
                    extraEdges += edgesCount - nodesCount + 1;
                }
            }
        }
        if (components > 1) {
            int neededEdges = components - 1;
            if (extraEdges >= neededEdges) return neededEdges;
            return -1;
        }
        return 0;
    }
    
    public int findConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int extraEdges = 0;
        int components = 0;
        for(int[] connection: connections) {
            int u = connection[0], v = connection[1];
            int p1 = findParent(parent, u);
            int p2 = findParent(parent, v);
            if (p1 == p2) {
                extraEdges++;
            } else {
                parent[p2] = p1;
            }
        }        
        for (int i=0; i<n; i++) {
            if (i == parent[i]) components++;
        }
        return (extraEdges >= components - 1) ? components - 1: -1;
    }
    
    public int findParent(int[] par, int i) {
        if (par[i] == i) return i;
        return par[i] = findParent(par, par[i]);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<List<Integer>> createGraph(int N, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public void dfsUtil(int start, List<List<Integer>> list, Set<Integer> visited, Set<String> edges) {
        visited.add(start);
        for(int neighbor: list.get(start)) {
            // edge between start and neighbor
            String prefix = (start < neighbor)? start + "," + neighbor: neighbor + "," + start;
            edges.add(prefix);
            if (visited.contains(neighbor)) continue;
            dfsUtil(neighbor, list, visited, edges);
        }        
    }

}