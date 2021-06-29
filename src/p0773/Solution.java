package p0773;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private final int[][] STATUS = { { 1, 2, 3 }, { 4, 5, 0 } };

    public int slidingPuzzle(int[][] board) {
        List<Integer> path = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int GOAL = toKeyValue(STATUS);
        int start = toKeyValue(board);
        if (GOAL == start) {
            return 0;
        }

        path.add(start);
        map.put(start, 0);

        for (int i = 0; i < path.size(); i++) {
            board = toBoard(board, path.get(i));
            int[] zp = getZero(board);
            for (int j = 0; j < direction.length; j++) {
                int nx = zp[0] + direction[j][0], ny = zp[1] + direction[j][1];
                if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                    board[zp[0]][zp[1]] = board[nx][ny];
                    board[nx][ny] = 0;
                    int key = toKeyValue(board);
                    if (key == GOAL) {
                        return map.get(path.get(i)) + 1;
                    } else if (!map.containsKey(key)) {
                        path.add(key);
                        map.put(key, map.get(path.get(i)) + 1);
                    }

                    board[nx][ny] = board[zp[0]][zp[1]];
                    board[zp[0]][zp[1]] = 0;
                }
            }
        }

        return -1;
    }

    private int toKeyValue(int[][] board) {
        int key = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                key = key << 3;
                key = key ^ board[i][j];
            }
        }
        return key;
    }

    private int[][] toBoard(int[][] board, int key) {
        for (int i = 1; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                board[i][j] = key & 7;
                key = key >> 3;
            }
        }
        return board;
    }

    private int[] getZero(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }
    
    public static void main(String args[]) {
        int[][] board = {{4,1,2}, {5,0,3}};
        Solution s = new Solution();
        s.slidingPuzzle(board);
    }
}
