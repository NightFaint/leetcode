#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/25 16:52'

class Solution1:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        #很明显可以利用一个栈来判断
        #只要用到栈的push，pop，isEmpty，可以用一个列表来充当
        #复杂度O(n)
        #36ms,击败99.85%
        lst=[]
        dic={')':'(',']':'[','}':'{'}
        balance=True
        for i in s:
            if i in ['(','{','[']:
                lst.append(i)
            else:
                if not lst:
                    balance=False
                    break
                else:
                    cur=lst.pop()
                    if dic[i] != cur:
                        balance=False
                        break
        return balance and len(lst)==0



#复杂度O(n)*k
#60ms，击败21%
class Solution2:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)
        if n == 0:
            return True
        if n % 2 != 0:
            return False
        while '()' in s or '{}' in s or '[]' in s:
            s = s.replace('()','').replace('{}','').replace('[]','')
        if s == '':
            return True
        else:
            return False

