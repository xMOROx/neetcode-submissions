class Solution {
    static class Pair implements Comparable<Pair> {
        int k;
        int v;

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.v, this.v);
        }

        public Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (var num: nums) {
            map.merge(num, 1, Integer::sum);
        }

        var pq = new PriorityQueue<Pair>();
        for (var kv: map.entrySet()) {
            var key = kv.getKey();
            var val = kv.getValue();
            var pair = new Pair(key, val);
            pq.add(pair);
        }
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().k;
        }
        return result;
    }
}
