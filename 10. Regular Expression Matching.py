#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 20:31'


class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # 备忘机制的动态规划
        # 子问题s[i:]和p[j:]是否match
        # 子问题个数O(n)
        # 每个子问题计算复杂度O(1)
        #64ms，击败90%
        ls = len(s)
        lp = len(p)
        memo = {}

        def dp(i, j):

            if (i, j) not in memo:
                if j == lp:
                    ans = i == ls  # 最低层
                else:
                    first_match = i < ls and p[j] in {s[i], '.'}
                    if j + 1 < lp and p[j + 1] == '*':
                        ans = dp(i, j + 2) or (first_match and dp(i + 1, j))
                    else:
                        ans = first_match and dp(i + 1, j + 1)
                memo[i, j] = ans
            return memo[i, j]

        return dp(0, 0)