#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/14 20:43'


class Solution:
    def myAtoi(self, strin):
        """
        :type str: str
        :rtype: int
        """
        #计算复杂度O(n),64ms,击败94%
        s = strin.strip()
        if not s:
            return 0
        res = ''
        if s[0] == '+' or s[0] == '-':
            res += s[0]
            s = s[1:]
            if not s:
                return 0
        if s[0].isnumeric():
            for i in s:
                if not i.isnumeric():
                    break
                res += i
            res = int(res)
            if res > 2 ** 31 - 1:
                return 2 ** 31 - 1
            elif res < -2 ** 31:
                return -2 ** 31
            else:
                return res

        else:
            return 0