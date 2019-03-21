#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/14 20:17'


#简单的题目，没啥好讲
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x > 2**31-1 or x < -2**31:
            return 0
        strnum = str(x)
        sign = 0
        if strnum[0] == '-':
            sign = 1
            strnum=strnum[1:]
        n = len(strnum)
        #remain = x
        res=0
        for i in reversed(range(n)):
            res+=int(strnum[i])*10**i
        res = (-1)**sign * res
        if res > 2**31-1 or res < -2**31:
            return 0
        return res