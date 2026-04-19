class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (var str: strs) {
            result.append("#").append(str.length()).append("#").append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        int current = 0;
        List<String> results = new ArrayList<>();
        var stack = new ArrayDeque<Integer>();
        while(current < n) {
            if(str.charAt(current) == '#') {
                int i = 1;
                while(true) {
                    System.out.println(str.charAt(current + i));
                    var c = str.charAt(current + i++) - 48;
                    if(c == -13) break;
                    stack.addLast(c);
                }
                int num = 0;
                int m = stack.size();
                int l = stack.size() - 1;
                while(!stack.isEmpty()) {
                    num += Math.pow(10, l) * stack.pollFirst();
                    l--;
                }
                results.add(str.substring(current + 2 + m, current + 2 + num + m ));
                current += (2 + num + m);
            }
        }
        return results;
    }
}
