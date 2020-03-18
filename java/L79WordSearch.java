import org.junit.Test;

public class L79WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (traverve(board, check, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param check
     * @param word
     * @param index 字母索引
     * @param curRow 字母位置
     * @param curCol 字母位置
     * @return
     */
    private boolean traverve(char[][] board, boolean[][] check, String word, int index, int curRow, int curCol) {
        if (index >= word.length()) {
            return true;
        }
        if (curRow < 0 || curCol < 0 || curRow >= board.length || curCol >= board[0].length) {
            return false;
        }
        if (board[curRow][curCol] != word.charAt(index)) {
            return false;
        }
        check[curRow][curCol] = true;
        boolean res = traverve(board, check, word, index + 1, curRow -1, curCol) // 上
                || traverve(board, check, word, index + 1, curRow + 1, curCol) // 下
                || traverve(board, check, word, index + 1, curRow, curCol - 1) // 左
                || traverve(board, check, word, index + 1, curRow, curCol + 1); // 右
        check[curRow][curCol] = false;
        return res;
    }

    @Test
    public void  test() {
        L79WordSearch ws = new L79WordSearch();
        char[] c1 = {'C','A','A'};
        char[] c2 = {'A', 'A', 'A'};
        char[] c3 = {'B', 'C', 'D'};
        char[][] board = new char[3][3];
        board[0] = c1;
        board[1] = c2;
        board[2] = c3;
        System.out.println(ws.exist(board, "AAB"));
    }
}
