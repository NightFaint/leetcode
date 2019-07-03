public class L999_Available_Captures_for_Rook {
    public int numRookCaptures(char[][] board) {
        int row = 0;
        int col = 0;
        boolean exist = false;
        // 找出Rook的位置
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == 'R') {
                    row = i;
                    col = j;
                    exist = true;
                    break;
                }
            }
        }
        // 不存在Rook，返回0
        if (!exist) {
            return 0;
        }
        // 存在rook，则从四个方向寻找
        else {
            int count = 0;
            // 左方向
            for(int i = col - 1; i >= 0; i--) {
                if (board[row][i] == 'B') {
                    break;
                } else {
                    if (board[row][i] == 'p') {
                        count++;
                        break;
                    }
                }
            }
            // 右方向
            for (int i = col + 1; i < 8; i++) {
                if (board[row][i] == 'B') {
                    break;
                } else {
                    if (board[row][i] == 'p') {
                        count++;
                        break;
                    }
                }
            }
            // 上方向
            for (int j = row - 1; j >= 0; j--) {
                if (board[j][col] == 'B') {
                    break;
                } else {
                    if (board[j][col] == 'p') {
                        count++;
                        break;
                    }
                }
            }
            // 下方向
            for (int j = row + 1; j < 8; j++) {
                if (board[j][col] == 'B') {
                    break;
                } else {
                    if (board[j][col] == 'p') {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }

    }
}
