#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/30 14:06'


class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in range(9):
            for j in range(9):
                if board[i][j].isnumeric():
                    # 查找所在的行、列是否有重复元素
                    if board[i][j] in board[i][j + 1:] or board[i][j] in [sub[j] for sub in board[i + 1:]]:
                        return False

                    # 查找所在子方格有没有重复元素
                    row = i // 3
                    col = j // 3
                    sub_board = [x for sub in board[3 * row:3 * row + 3] for x in sub[col * 3:col * 3 + 3]]
                    sub_board.remove(board[i][j])  # 去除掉本身
                    if board[i][j] in sub_board:
                        return False
        return True