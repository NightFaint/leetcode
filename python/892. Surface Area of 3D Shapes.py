#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:49'
class Solution:
    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        total=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                total+=grid[i][j]*4+2 if grid[i][j]>0 else 0
                if j < len(grid[0])-1:
                    total-=min(grid[i][j],grid[i][j+1])*2
                if i < len(grid)-1:
                    total-=min(grid[i][j],grid[i+1][j])*2
        return total
