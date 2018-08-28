#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:44'

class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows=len(grid)
        cols=len(grid[0])
        d_list=[]
        for i in range(rows):
            d_list.append([10000]*cols)
        d_list[0][0]=grid[0][0]
        for i in range(rows):
            for j in range(cols):
                if i >0:
                    d = d_list[i-1][j]+grid[i][j]
                    if d_list[i][j] >d:
                        d_list[i][j]=d
                if j >0:
                    d = d_list[i][j-1]+grid[i][j]
                    if d_list[i][j]>d:
                        d_list[i][j]=d
        return d_list[rows-1][cols-1]