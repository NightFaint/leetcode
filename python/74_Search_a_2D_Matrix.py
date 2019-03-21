#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/2 14:02'


'''
简单来说，就是进行两次BST查找。
先BST查找是处于哪一行，再在那一行进行BST
复杂度：O(lg(m+n))
'''

class Solution:
    def searchRow(self, row, target):
        n = len(row)
        if n == 0:
            return False
        elif row[n // 2] == target:
            return True
        elif row[n // 2] < target:
            return self.searchRow(row[n // 2 + 1:], target)
        else:
            return self.searchRow(row[:n // 2], target)

    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False
        m = len(matrix)
        if m == 1:
            return self.searchRow(matrix[0], target)
        elif matrix[m // 2 - 1][0] <= target and matrix[m // 2][0] > target:
            return self.searchRow(matrix[m // 2 - 1], target)
        elif matrix[m // 2 - 1][0] <= target and matrix[m // 2][0] <= target:
            return self.searchMatrix(matrix[m // 2:], target)
        elif matrix[m // 2 - 1][0] > target and matrix[m // 2 - 2][0] > target:
            return self.searchMatrix(matrix[:m // 2 - 1], target)
        else:
            return self.searchRow(matrix[m // 2 - 2], target)
