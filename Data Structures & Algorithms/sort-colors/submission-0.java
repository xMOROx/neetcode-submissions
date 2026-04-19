class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1); 
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (r <= l + 1) {
            if(r == l + 1 && nums[l] > nums[r]) swap(nums, l, r);
            return;
        }

        int p = partition(nums, l, r);

        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int partition(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1); 
        swap(nums, mid, left + 1); 

        if(nums[left] > nums[right]) swap(nums, left, right);
        if(nums[left + 1] > nums[right]) swap(nums, left + 1, right);
        if(nums[left] > nums[left + 1]) swap(nums, left, left + 1);

        int pivot = nums[left + 1]; 
        int i = left + 1; 
        int j = right;

        while(true) {
            while(nums[++i] < pivot);
            while(nums[--j] > pivot);
            if(i > j) break;
            swap(nums, i, j);
        }

        nums[left + 1] = nums[j];
        nums[j] = pivot;

        return j;
    }
}