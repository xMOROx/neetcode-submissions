class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int num : nums) {
            if (num != val) {
                left++;
            }
        }
        int[] new_arr = new int[left];
        int j = 0;
        for (int num : nums) {
            if (num != val) {
                new_arr[j] = num;
                j++;
            }
        }

        System.arraycopy(new_arr, 0, nums, 0, left);
        return left;
    }
}