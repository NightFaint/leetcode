#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/28 10:44'


class Solution:
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        # 深度优先搜索
        #复杂度O(V+E)

        result = []
        self.dfs(result, '', 0, 0, n)
        return result

    def isValid(self, left, right, n):
        return left >= right and left <= n and right <= n

    def dfs(self, result, path, left, right, n):
        if not self.isValid(left, right, n):
            return

        if len(path) == 2 * n:
            result.append(path)
        else:
            self.dfs(result, path + '(', left + 1, right, n)
            self.dfs(result, path + ')', left, right + 1, n)
