class Solution {
    static class Pair {
        String id;
        long count;
        Pair(String id, long count) {
            this.id = id;
            this.count = count;
        }
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        int n = creators.length;
        Map<String, Long> nameToViews = new HashMap<>();
        Map<String, Pair> nameToPair = new HashMap<>();
        for(int i=0; i<n; i++) {
            String name = creators[i];
            String id = ids[i];
            long current_count = views[i];
            nameToViews.computeIfAbsent(name, k->0L);
            nameToViews.put(name, nameToViews.get(name) + current_count);
            // update view_count
            if (!nameToPair.containsKey(name)) {
                nameToPair.put(name, new Pair(id, current_count));
            } else {
                Pair p = nameToPair.get(name);
                if (p.count < current_count) {
                    p.count = current_count;
                    p.id = id;
                } else if(p.count == current_count) {
                    if (id.compareTo(p.id) < 0) {
                        p.id = id;
                    }
                }
            }
        }
        List<Map.Entry<String, Long>> entry_list = new ArrayList<>(nameToViews.entrySet());
        Collections.sort(entry_list, (a, b) -> {
           return Long.compare(b.getValue(), a.getValue()); 
        });
        long max = entry_list.get(0).getValue();
        for(int i=0; i<entry_list.size(); i++) {
            if(entry_list.get(i).getValue() == max) {
                result.add(Arrays.asList(entry_list.get(i).getKey(), nameToPair.get(entry_list.get(i).getKey()).id));
            } else {
                break;
            }
        }
        return result;
    }
}