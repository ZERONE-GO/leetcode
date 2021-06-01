package o0012;

public class Solution {

    private int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        boolean[][] color = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word, 0, color)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, int x, int y, String word, int index, boolean[][] color) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        color[x][y] = true;
        boolean result = false;
        for (int i = 0; i < direction.length; i++) {
            int nx = x + direction[i][0], ny = y + direction[i][1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !color[nx][ny]) {
                result = check(board, nx, ny, word, index + 1, color);
                if (result) {
                    return true;
                }
            }
        }
        color[x][y] = false;
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        char[][] board= {{'a', 'b'}};
        String word = "ba";
        s.exist(board, word);
    }
}
