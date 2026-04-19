class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int j = 0;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                left++;
                j++;
            }
        }

        return left;
    }
}