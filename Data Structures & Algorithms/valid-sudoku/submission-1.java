class Solution {
    public boolean isValidSudoku(char[][] board) {
        var n = board.length;
        var map = new HashMap<Character, Integer>();
        for (char[] chars : board) {
            if (!isValidRow(chars)) return false;
        }

        for (int j = 0; j < n; j++) {
            map = new HashMap<>();
            for (char[] chars : board) {
                if(chars[j] == '.') continue;
                map.merge(chars[j], 1, Integer::sum);
            }
            if(map.values().stream().anyMatch(v -> v > 1)) return false;
        }


        for (int i = 0; i < n; i+=3) {
            

            for (int k = 0; k < 3; k++) {
                map = new HashMap<>();
                for (int j = k * 3; j < (k + 1) * 3; j++) {
                    for (int l = 0; l < 3; l++) {
                        var ch = board[i + l][j];
                        if(ch == '.') continue;
                        map.merge(ch, 1, Integer::sum);
                    }
                }
                if(map.values().stream().anyMatch(v -> v > 1)) return false;
            }
            
        }


        return true;
    }

    private boolean isValidRow(char[] row) {
        var map = new HashMap<Character, Integer>();

        for (char c : row) {
            if(c == '.') continue;
            map.merge(c, 1, Integer::sum);
        }
        return map.values().stream().noneMatch(v -> v > 1);
    }
}
