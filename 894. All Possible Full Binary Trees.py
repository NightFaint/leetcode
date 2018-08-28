#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:48'

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#带备忘的动态规划

class Solution:
    def allPossibleFBT(self, N):
        """
        :type N: int
        :rtype: List[TreeNode]
        """
        memo={}
        memo[1]=[TreeNode(0)]
        if N==1:
            return memo[1]
        if N%2==0:
            return []
        for i in range(3,N+1,2):
            memo[i]=[]
            for j in range(1,i-1,2):
                left=memo[j]
                right=memo[i-1-j]
                for x in left:
                    for y in right:
                        node=TreeNode(0)
                        node.left=x
                        node.right=y
                        memo[i].append(node)
        return memo[N]