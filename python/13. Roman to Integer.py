#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 20:16'

class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        #复杂度O(n)
        #148ms,击败61%
        d = {'C': 100, 'D': 500, 'I': 1, 'L': 50, 'M': 1000, 'V': 5, 'X': 10}
        res=0
        for i in range(len(s)):
            res+=d[s[i]]

            #通过观察发现，如果一个比较小的罗马数字排在前面，那么其实这个数应该减去的，之前加过一次，所以减去两倍
            if i < len(s)-1 and d[s[i]] < d[s[i+1]]:
                res -= 2*d[s[i]]
        return res