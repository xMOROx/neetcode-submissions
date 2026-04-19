class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int j = 0;

        for (int num : nums) {
            if (num != val) {
                nums[j] = num;
                left++;
                j++;
            }
        }

        return left;
    }
}