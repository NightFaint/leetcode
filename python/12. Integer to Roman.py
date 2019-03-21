#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 16:25'


class Solution1:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        M = ["", "M", "MM", "MMM"];
        C = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"];
        X = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"];
        I = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"];
        return M[num//1000]+C[(num%1000)//100]+X[(num%100)//10]+I[(num%10)]


class Solution2:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """

        res = ''
        thous = num // 1000
        res += thous * 'M'
        num = num % 1000
        s = str(num)
        n = len(s)

        d = {1: 'I', 5: 'V', 10: 'X', 50: 'L', 100: 'C', 500: 'D', 1000: 'M'}
        # roman=['I','V','X','L','C','D','M']
        # integer=[1,5,10,50,100,500,1000]
        # d=dict(zip(integer,roman))
        for i in reversed(range(n)):
            j = num // (10 ** i)
            if j < 4:
                res += j * d[10 ** i]
            elif j == 4:
                res += d[10 ** i] + d[10 ** i * 5]
            elif j < 9:
                res += d[10 ** i * 5] + (j - 5) * d[10 ** i]
            else:
                res += d[10 ** i] + d[10 ** (i + 1)]
            num = num % (10 ** i)
        return res


