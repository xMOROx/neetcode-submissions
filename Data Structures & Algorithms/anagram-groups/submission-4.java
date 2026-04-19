class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var n = strs.length;
        var map = new HashMap<String, List<String>>();
        var counting = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (var c: strs[i].toCharArray()) {
                counting[i][c - 'a']++;
            }
            var key = Arrays.toString(counting[i]);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
