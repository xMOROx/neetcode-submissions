class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       var n = strs.length;
        var sorted = new String[n][2];
        var map = new HashMap<String, List<String>>();

        for (var i = 0; i < n; i++) { // O(n) ->
            var arr = strs[i].toCharArray();
            Arrays.sort(arr); // O(m*log(m))
            sorted[i][0] = new String(arr);
            sorted[i][1] = strs[i];
        } // O(n * max(m)*log(max(m)))

        System.out.println(Arrays.deepToString(sorted));
        for (var values: sorted) {
            var key = values[0];
            var value = values[1];
            var list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }


        return new ArrayList<>(map.values());
    }
}
