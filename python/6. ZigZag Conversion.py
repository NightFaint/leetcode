#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/14 20:05'


class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        # 构建numRows个列表，然后依顺序将字符添加到对应的列表里，从列表0开始递增，到1，到...numRows-1，然后递减，减到零又开始递增，如此。
        # 计算复杂度O(n),n=len(s)，92ms，击败80.6%
        # 空间复杂度O(n)
        if numRows == 1 or numRows > len(s):
            return s
        rowlist = [''] * numRows
        index = 0
        step = 1
        for i in s:
            rowlist[index] += i
            if index == 0:
                step = 1
            if index == numRows - 1:
                step = -1
            index += step

        from functools import reduce
        from operator import add
        resl = reduce(add, rowlist)
        return resl