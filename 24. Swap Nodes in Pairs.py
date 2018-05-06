#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/6 13:25'


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        para0 = ListNode(0)
        start = ListNode(0)  # 用来记录，保证start.next返回的是所求list的头部

        # 如果链表元素有两个及以上，则返回的链表头部是原链表的第二个元素
        # 否则，及链表则有一个元素，返回
        if head.next:
            start.next = head.next
        else:
            return head

        para1 = head
        para0.next = para1

        # 循环，每一次调换两个元素位置，并更新para0,和para1
        while para1:
            para2 = para1.next
            # 当para2不为None时，才有para3，para0.next=para2，para2才有next属性
            if para2:
                para3 = para1.next.next
                para0.next = para2
                para2.next = para1
                para1.next = para3
            para0 = para1  # 更新para0
            # 当para2不为None，更新para1为para3，否则para1为None
            if para2:
                para1 = para3
            else:
                para1 = para2
        return start.next