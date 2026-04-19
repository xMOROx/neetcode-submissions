class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [][] A = new int[n][2];

        for (int i = 0; i < n; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }

        Arrays.sort(A, Comparator.comparing((a) -> a[0]));

        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int a = A[i][0];
            int b = A[j][0];
            if (a + b == target) return new int[]{Math.min(A[i][1],A[j][1]), Math.max(A[i][1],A[j][1])};
            else if (a + b < target) i++;
            else j--;
        }

        return new int[0];
    }
}
