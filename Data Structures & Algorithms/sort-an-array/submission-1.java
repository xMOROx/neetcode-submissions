class Solution {
    public int[] sortArray(int[] nums) {
        int[] tmp = new int[nums.length]; 
        int[] result = new int[nums.length]; 
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        mergeSort(result, tmp, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) return; 

        int mid = left + ((right - left) >> 1); 

        mergeSort(nums, tmp, left, mid); 
        mergeSort(nums, tmp, mid + 1, right); 
        merge(nums, tmp, left, mid, right); 
    }

    private void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1; 
        int idx = left;

        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                tmp[idx] = nums[i];
                i++;
            } else {
                tmp[idx] = nums[j];
                j++;
            }
            idx++;
        }

        while(i <= mid) {
            tmp[idx] = nums[i];
            i++;
            idx++;
        }

        while(j <= right) {
            tmp[idx] = nums[j];
            j++;
            idx++;
        }

        for(int k = left; k <= right; k++) {
            nums[k] = tmp[k];
        }
    }
}