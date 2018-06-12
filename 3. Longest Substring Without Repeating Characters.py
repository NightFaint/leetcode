#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/12 22:21'

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxi=0
        sub=''
        for i in range(len(s)):
            if s[i] not in sub:
                sub+=s[i]
            else:
                sub=sub[sub.index(s[i])+1:]+s[i]#去掉重复字符及其前面的字符，再加上现有字符
            if len(sub) > maxi:
                maxi=len(sub)
        return maxi

#另一种解法
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        store = {}
        ret = start = idx = 0 # we need to initialize idx now in case of an empty string
        for idx, char in enumerate(s, 1):
            if char in store and start <= store[char]:
                start = store[char]
            store[char] = idx
            ret = max(ret, idx-start) # we only need to store the longest substring length
        return ret