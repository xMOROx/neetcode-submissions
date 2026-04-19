class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int x = -1, y = -1;

        for (int i = 0; i < n; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            x = map.getOrDefault(nums[i], -1);
            if (x > 0 && x != i ) {
                y = i;
                break;
            }
        }
        return x < y? new int[]{x, y}: new int[]{y, x};
    }
}
