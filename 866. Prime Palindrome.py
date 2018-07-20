#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:31'

import math


class Solution:
    def primePalindrome(self, N):
        """
        :type N: int
        :rtype: int
        """
        digits = len(str(N))
        while True:
            for x in self.generatepali(digits):
                if x >= N and self.isPrime(x):
                    return x
            digits += 1

    def isPrime(self, n):
        if n <= 1:
            return False
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
        return True

    def generatepali(self, n):
        if n == 1:
            for i in range(10):
                yield i
        elif n % 2 == 0:
            d = n // 2
            for i in range(10 ** (d - 1), 10 ** d):
                s = str(i)
                yield int(s + s[::-1])
        else:
            d = n // 2
            for i in range(10 ** (d - 1), 10 ** d):
                s = str(i)
                for j in range(10):
                    yield int(s + str(j) + s[::-1])