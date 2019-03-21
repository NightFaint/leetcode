#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/25 16:50'


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


#复杂度O(n)
#44ms，击败95%
class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        cur = head
        count = 0
        while cur:
            count += 1
            cur = cur.next
        k = count - n
        cur = dummy
        while k > 0:
            cur = cur.next
            k -= 1

        cur.next = cur.next.next
        return dummy.next