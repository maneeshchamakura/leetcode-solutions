class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, List<Pair<Character, Integer>>> graph = new HashMap<>();
        int len = cost.length;
        for (int i=0; i<len; i++) {
            List<Pair<Character, Integer>> nbs = graph.computeIfAbsent(original[i], k -> new ArrayList<>());
            nbs.add(new Pair<>(changed[i], cost[i]));
            graph.put(original[i], nbs);
        }
        Map<Pair<Character, Character>, Long> memo = new HashMap<>();
        long total = 0L;
        for (int i=0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);
            if (c1 == c2) continue;
            long val = dijkstra(c1, c2, graph, memo);
            if (val == -1L) return -1L;
            total += val;
        }
        return total;
    }

    public long dijkstra(char source, char target, Map<Character, List<Pair<Character, Integer>>> graph, Map<Pair<Character, Character>, Long> memo) {
        if (memo.containsKey(new Pair<>(source, target))) return memo.get(new Pair<>(source, target));
        PriorityQueue<Pair<Character, Long>> minHeap = new PriorityQueue<>(Comparator.comparingLong(p -> p.getValue()));
        Map<Character, Long> dist = new HashMap<>();
        minHeap.offer(new Pair<>(source, 0L));
        dist.put(source, 0L);
        Set<Character> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Pair<Character, Long> pair = minHeap.poll();
            visited.add(pair.getKey());
            if (pair.getKey() == target) {
                memo.put(new Pair<>(source, target), pair.getValue());
                return pair.getValue();
            }
            if (dist.get(pair.getKey()) < pair.getValue()) continue;
            // get all the nbs
            List<Pair<Character, Integer>> nbs = graph.get(pair.getKey());
            if (Objects.isNull(nbs)) continue;
            for(Pair<Character, Integer> nb: nbs) {
                char change_char = nb.getKey();
                int cost = nb.getValue();
                if (visited.contains(change_char)) continue;                
                long new_distance = cost + dist.get(pair.getKey());                
                if (Objects.isNull(dist.get(change_char))) {
                    dist.put(change_char, new_distance);
                    minHeap.offer(new Pair<>(change_char, new_distance));
                    continue;
                }
                long stored_distance = dist.get(change_char);
                if (stored_distance > new_distance) {
                    // update the value in dist map
                    dist.put(change_char, new_distance);
                    // minHeap.remove(new Pair<>(change_char, stored_distance));
                    minHeap.offer(new Pair<>(change_char, new_distance));
                }
            }
        }
        memo.put(new Pair<>(source, target), -1L);
        return -1L;
    }
}