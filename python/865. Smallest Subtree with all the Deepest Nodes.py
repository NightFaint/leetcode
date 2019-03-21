#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:32'


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        d = self.finddeep(root, 0)
        n = d[0]
        for i in range(n):
            if d[1] == 'l':
                root = root.left
            elif d[1] == 'r':
                root = root.right
            else:
                return root
            d = self.finddeep(root, 0)

        return root

    def finddeep(self, node, depth):
        if node == None:
            return [depth - 1, 'm']
        if node.left or node.right:
            l = self.finddeep(node.left, depth + 1)
            r = self.finddeep(node.right, depth + 1)
            if l[0] > r[0]:
                return [l[0], 'l']
            elif l[0] < r[0]:
                return [r[0], 'r']
            else:
                return [r[0], 'm']
        else:
            return [depth, 'm']