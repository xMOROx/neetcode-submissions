class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        var result = strs[0];

        for (var str: strs) {
            if (str.isEmpty()) return "";
            for (int j = 0; j < Math.max(result.length(), str.length()); j++) {
                if(j >= Math.min(str.length(), result.length()) ) {
                    if(str.length() < result.length()) result = str;
                    break;
                } else if (result.charAt(j) != str.charAt(j)) {
                    result = str.substring(0, j);
                    break;
                }
            }
        }

        return result;
    }
}