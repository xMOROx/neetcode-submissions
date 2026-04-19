class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var it = s.chars().iterator(); it.hasNext(); ) {
            var c = it.next();
            map.compute(c, (key, value) -> value == null? 1: value + 1);
        }

        for (var it = t.chars().iterator(); it.hasNext(); ) {
            var c = it.next();
            map.compute(c, (key, value) -> value == null? 1: value - 1);
        }
        return map.values().stream().allMatch(value -> value == 0);
    }
}
