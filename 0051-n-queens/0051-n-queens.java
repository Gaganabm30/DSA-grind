import java.util.*;

class Solution {

    private boolean isSafe(List<String> board, int row, int col) {

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {

            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }

            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >= 0) {

            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }

            r--;
        }

        r = row;
        c = col;

        while (r >= 0 && c < board.size()) {

            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }

            r--;
            c++;
        }

        return true;
    }

    private void backtrack(int row,List<String> board,List<List<String>> ans) {

        if (row == board.size()) {

            ans.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {

            if (isSafe(board, row, col)) {

                char[] currentRow = board.get(row).toCharArray();
                currentRow[col] = 'Q';
                board.set(row, new String(currentRow));

                backtrack(row + 1, board, ans);

                currentRow[col] = '.';
                board.set(row, new String(currentRow));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        backtrack(0, board, ans);

        return ans;
    }
}