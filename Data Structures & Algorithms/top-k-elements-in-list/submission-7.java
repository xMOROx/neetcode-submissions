class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        var maxi = map.values().stream().max(Integer::compareTo).get();
        var buckets = new ArrayList<List<Integer>>();

        for (int i = 0; i <= maxi; i++) {
            buckets.add(new ArrayList<>());
        }

        for (var entry: map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            buckets.get(value).add(key);
        }

        var result = new int[k];
        var idx = 0;
        for (int i = maxi; i >= 0; i--) {
            for (var val:  buckets.get(i)) {

                result[idx++] = val;
                if (idx == k) break;
            }
            if (idx == k) break;
        }
        return result;
    }

    static {
        int[] input = {1, 1, 2, 2, 3};
        for (int i = 0; i < 100; i++) {
            topKFrequent(input, 2);
        }
    }
}