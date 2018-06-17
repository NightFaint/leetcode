#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 20:30'

class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        #280ms,击败86%
        if x < 0:
            return False
        s=str(x)
        n=len(s)
        i=0
        j=n-1
        while i < j:
            if s[i] != s[j]:
                return False
            i+=1
            j-=1
        return True