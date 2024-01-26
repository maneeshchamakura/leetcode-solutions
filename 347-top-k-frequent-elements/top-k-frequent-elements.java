class Solution {
    static class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        List<Pair> pairs = new ArrayList<>();
        for(int key: map.keySet()) {
            pairs.add(new Pair(key, map.get(key)));
        }
        quick_select(pairs, k-1);
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = pairs.get(i).num;
        }
        return result;
    }

    public void quick_select(List<Pair> pairs, int k) {
        int start = 0, end=pairs.size() - 1;
        while (start <= end) {            
            int index = partition(pairs, start, end);
            if (index == k) {
                return;
            } else if(index < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
    }

    public int partition(List<Pair> pairs, int start, int end) {
        Random rand = new Random();
        int pivot = start + rand.nextInt(end - start + 1);
        swap(pairs, pivot, end);
        int index = start;
        for (int i=start; i<end; i++) {
            if(pairs.get(i).count > pairs.get(end).count) {
                swap(pairs, index, i);
                index++;
            }
        }
        swap(pairs, index, end);
        return index;
    }

    public void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);
    }
}