class Solution {
    public String longestCommonPrefix(String[] strs) {
        var shortest = Arrays.stream(strs).min((Comparator.comparingInt(String::length))).get();
        var result = shortest;
        boolean skip = false;
        for (int i = shortest.length(); i >= 0 ; i--) {
            skip = false;
            for (String str : strs) {
                if (str.equals(shortest)) continue;
                if (!str.substring(0, shortest.substring(0, i).length()).equals(shortest.substring(0, i))) {
                    skip = true;
                    break;
                }

            }
            if (!skip) {
                result = shortest.substring(0, i);
                break;
            }
        }
        
        return result;
    }
}