#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/6 15:00'


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 复杂度O(n)
# extra memory:4=O(1)
class Solution:
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        # 注意，当prev未被重新赋值时，即id(prev)=id(dummy)不变时，prev和dummy都是对同一个对象的引用，当prev.next变化时，dummy.next也变化
        prev = dummy
        # print(id(dummy))

        # 如果链表为空或者k==1(不用排序),返回原链表
        if not head or k == 1:
            return head
        # 循环每次都对k个元素进行逆排序，直到剩下的元素不足k个
        while prev.next:
            # 当prev被重新赋值时，prev和dumm已无关系
            prev = self.reverseKList(prev, k)

        return dummy.next

    def reverseKList(self, prev, k):
        cur = prev.next
        # 如果长度不足k了，返回最后一个元素，它的next为None
        for i in range(k - 1):
            if cur.next != None:
                cur = cur.next
            else:
                return cur
        # 从prev.next开始，revHead记录逆序的头部
        cur = prev.next
        revHead = cur
        for i in range(k - 1):
            nextEle = cur.next
            nextLink = nextEle.next
            nextEle.next = revHead
            revHead = nextEle
            cur.next = nextLink

        prev.next = revHead  # 原来prev.next是cur，更新为逆序头部
        # print('\n',id(prev))
        return cur



