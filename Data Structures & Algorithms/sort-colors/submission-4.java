class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[]{0,0,0}; 

        for(int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }

        int j = buckets[0] > 0 ? 0 : (buckets[1] > 0 ? 1 : 2);

        for(int i = 0; i < nums.length; i++) {
            nums[i] = j;
            if(--buckets[j] < 1) j++;
        }
    }

    
}