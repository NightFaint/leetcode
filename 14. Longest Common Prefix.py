#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 16:49'


class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        # 动态规划
        # 子问题个数O(n)
        # 子问题复杂度O(len(strs[i]))
        #52ms，击败30%
        if not strs:
            return ''

        n = len(strs)
        if n < 2:
            return strs[0]
        return self.dp(1, strs[0], strs)

    def dp(self, i, prefix, strs):
        if i == len(strs):
            return prefix
        si = strs[i]
        n = min(len(prefix), len(si))
        common = ''
        for j in range(n):
            if prefix[j] == si[j]:
                common += si[j]
            else:
                break
        prefix = self.dp(i + 1, common, strs)
        return prefix


class Solution2:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        #复杂度O(n) * O(len(strs[i]))
        #42ms，击败97%
        if not strs:
            return ''

        #把每个字符串第一、二...个字符分别组成元组，再将各个元组转换成集合，如果集合元素超过1个，那么此时的位置已经不是共同的前缀了
        for i, letteri in enumerate(zip(*strs)):
            if len(set(letteri)) > 1:
                return strs[0][:i]
        return min(strs)