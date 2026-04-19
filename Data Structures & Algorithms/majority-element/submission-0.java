class Solution {
    public int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (var num: nums) {
            map.merge(num, 1, Integer::sum);
        }

        int maxi = -1;
        int max = -1;

        for (var entry: map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            if(value > max) {
                maxi = key;
                max = value;
            }
        }

        return maxi;
    }
}