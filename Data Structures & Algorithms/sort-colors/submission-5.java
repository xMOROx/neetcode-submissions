class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[]{0,0,0}; 

        for(int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }

        System.out.println(Arrays.toString(buckets));

        int j = 0;

        for(int i = 0; i < nums.length; i++) {
            while(buckets[j] < 1) {
                j++;
            } 
            nums[i] = j;
            --buckets[j];
        }
    }     
}