class Solution {
    public boolean isValidSudoku(char[][] board) {
        var n = board.length;
        var rows = new HashMap<Integer, HashSet<Character>>();
        var cols = new HashMap<Integer, HashSet<Character>>();
        var squares = new HashMap<String, HashSet<Character>>(); // key = "{i / 3}, {j / 3}"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;

                if(rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                        cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                        squares.computeIfAbsent("%d, %d".formatted(i / 3, j / 3), k -> new HashSet<>()).contains(board[i][j])
                ) return false;

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get("%d, %d".formatted(i / 3, j / 3)).add(board[i][j]);
            }
        }

        return true;
    }
}
