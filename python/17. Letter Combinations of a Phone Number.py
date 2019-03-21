#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/25 16:44'


class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        #递归
        #复杂度O(n)*3
        #36ms,击败97%
        if not digits:
            return []
        diction = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        lst = [diction[x] for x in digits]
        return self.recur(lst)

    def recur(self, lst):
        if len(lst) == 1:
            return [x for x in lst[0]]
        return [x + y for x in lst[0] for y in self.recur(lst[1:])]

class Solution2:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        #与第一个解法一样，优雅一点的写法
        # 递归
        from functools import reduce
        if not digits:
            return []
        diction={'2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno','7':'pqrs','8':'tuv','9':'wxyz'}
        return list(reduce(lambda acc,digit:[x + y for x in acc for y in diction[digit]],digits,['']))