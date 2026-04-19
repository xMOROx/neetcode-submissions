class Solution {
    public String longestCommonPrefix(String[] strs) {
        var map = new HashMap<String, Integer>();

        for (var str: strs) {
            for (int i = 0; i <= str.length(); i++) {
                map.merge(str.substring(0, i), 1, Integer::sum);
            }
        }
        var maxi = -1;
        var result = "";
        for (var entry: map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if ((key.length() > result.length() && value >= maxi) || (value > maxi)) {
                maxi = value;
                result = key;
            }
        }
        return result;
    }
}