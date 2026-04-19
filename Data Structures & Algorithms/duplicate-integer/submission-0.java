class Solution {
    public boolean hasDuplicate(int[] nums) {
        var duplicates = new HashSet<>();
        for (var num : nums) {
            if (duplicates.contains(num)) return true;
            duplicates.add(num);
        }

        return false;
    }
}