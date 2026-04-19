class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (var num: nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (var e: map.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        var result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (var item: buckets[i]) {
                result[index++] = item;
                if(index ==k) {
                    return result;
                }
            }
        }


        return result;
    }
}
